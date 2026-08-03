class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> corners = new HashSet<>();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int area = 0;

        for (int[] r : rectangles) {
            minX = Math.min(minX, r[0]);
            minY = Math.min(minY, r[1]);
            maxX = Math.max(maxX, r[2]);
            maxY = Math.max(maxY, r[3]);

            area += (r[2] - r[0]) * (r[3] - r[1]);

            String[] pts = {
                r[0] + " " + r[1],
                r[0] + " " + r[3],
                r[2] + " " + r[1],
                r[2] + " " + r[3]
            };

            for (String p : pts) {
                if (!corners.add(p)) {
                    corners.remove(p);
                }
            }
        }

        if (corners.size() != 4) return false;

        if (!corners.contains(minX + " " + minY) ||
            !corners.contains(minX + " " + maxY) ||
            !corners.contains(maxX + " " + minY) ||
            !corners.contains(maxX + " " + maxY)) {
            return false;
        }

        return area == (maxX - minX) * (maxY - minY);
    }
}