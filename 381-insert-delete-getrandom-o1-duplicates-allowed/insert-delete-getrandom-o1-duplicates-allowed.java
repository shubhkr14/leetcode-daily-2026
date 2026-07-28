class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();

        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);

        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);

        int lastVal = list.get(list.size() - 1);

        if (removeIdx != list.size() - 1) {
            list.set(removeIdx, lastVal);

            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(removeIdx);
        }

        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}