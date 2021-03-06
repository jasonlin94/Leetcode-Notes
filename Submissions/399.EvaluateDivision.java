class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Map<String, Double>> map = new HashMap<>(); // double大写
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            double val = values[i];
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<>());
            }
            map.get(a).put(b, val);
            map.get(b).put(a, 1/val);
        }
        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<String> set = new HashSet<>();
            String a = queries[i][0];
            String b = queries[i][1];
            results[i] = helper(a, b, 1.0, map, set);
            if (results[i] == 0.0) {
                results[i] = -1.0;
            }
        }
        return results;
    }
    private double helper(String start, String end, double result, 
                          HashMap<String, Map<String, Double>> map,
                          Set<String> set) {
        if (set.contains(start)) {
            return 0.0;
        }
        if (!map.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return result;
        }
        set.add(start);
        double temp = 0.0;
        Map<String, Double> neighbors = map.get(start);
        for (String neighbor : neighbors.keySet()) {
            double value = neighbors.get(neighbor);
            temp = helper(neighbor, end, result * value, map, set);
            if (temp != 0.0) {
                return temp;
            }
        }
        set.remove(start);
        return 0.0;
    }
}