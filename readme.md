# Map Operations

## Some simple operations on java.util.Collections.Map

### Functions included:

* sortMap(Map, boolean)

```
This function sort the map based on VALUES, rather based on keys.

e.g. Map(a,10);(b,2);(c,4) ==> Map(b,2);(c,4);(a,10)
```

* transposeMap(Map)

```
Switches key-value pairs to value-key pairs (duplicate values will be overwritten).

e.g. Map(a,10);(b,2);(c,4) ==> Map(10,a);(2,b);(4,c)
```