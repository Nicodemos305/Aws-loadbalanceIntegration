package br.com.desafio.loadbalance.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* Canonical Headers.
* <p>
* See http://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html for more information
* </p>
*
* @author Richard Lucas
*/
class CanonicalHeaders {

  private static final Collector<CharSequence, ?, String> HEADER_VALUE_COLLECTOR = Collectors.joining( "," );

  private final String names;
  private final String canonicalizedHeaders;
  private final TreeMap<String, List<String>> internalMap;

  private CanonicalHeaders(String names, String canonicalizedHeaders, TreeMap<String, List<String>> internalMap) {
      this.names = names;
      this.canonicalizedHeaders = canonicalizedHeaders;
      this.internalMap = internalMap;
  }

  String get() {
      return canonicalizedHeaders;
  }

  String getNames() {
      return names;
  }

  Optional<String> getFirstValue(String name) {
      return Optional.ofNullable(internalMap.get(name.toLowerCase()))
              .map(values -> values.get(0));
  }

  static Builder builder() {
      return new Builder();
  }

  static class Builder {

      private final TreeMap<String, List<String>> internalMap = new TreeMap<>();

      Builder add(String name, String value) {

          if (name == null) {
              throw new IllegalArgumentException("name is null");
          }

          if (value == null) {
              throw new IllegalArgumentException("value is null");
          }
          String lowerCaseName = name.toLowerCase();
          internalMap.put(lowerCaseName, Optional.ofNullable(internalMap.get(lowerCaseName))
                  .map(values -> {
                      values.add(value);
                      return values;
                  })
                  .orElse(newValueListWithValue(value)));
          return this;
      }

      CanonicalHeaders build() {
          String names = internalMap.keySet()
                  .stream()
                  .map(String::toLowerCase)
                  .collect(Collectors.joining(";"));

          StringBuilder canonicalizedHeadersBuilder = new StringBuilder();
          internalMap.entrySet()
                  .forEach(header -> canonicalizedHeadersBuilder
                          .append(header.getKey().toLowerCase())
                          .append(':')
                          .append(header.getValue().stream()
                                  .map(Builder::normalizeHeaderValue).collect(HEADER_VALUE_COLLECTOR)
                           )
                          .append('\n')
                  );

          return new CanonicalHeaders(names, canonicalizedHeadersBuilder.toString(), internalMap);
      }

      private List<String> newValueListWithValue(String value) {
          List<String> values = new ArrayList<>();
          values.add(value);
          return values;
      }

      private static String normalizeHeaderValue(String value) {
          /*
           * Strangely, the AWS test suite expects us to handle lines in
           * multi-line values as individual values, even though this is not
           * mentioned in the specs.
           */
          Stream<String> stream = Arrays.stream(value.split("\n"));

          // Remove spaces on the edges of the string
          stream = stream.map(String::trim);
          // Remove duplicate spaces inside the string
          stream = stream.map(s -> s.replaceAll(" +", " "));

          return stream.collect(HEADER_VALUE_COLLECTOR);
      }

  }
}
