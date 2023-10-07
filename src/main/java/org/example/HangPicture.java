package org.example;

public class HangPicture {

    void draw(int triesCount) {
        System.out.println(getMistakesHang(triesCount));
    }

    private String getMistakesHang(int count) {
        byte[] bytes;
        switch (count) {
            case (4): {
//                hang = "|\n|\n|\n|\n|\n|\n";
                bytes = new byte[]{124, 10, 124, 10, 124, 10, 124, 10, 124, 10, 124, 10};
                return new String(bytes);
            }
            case (3): {
//                hang = "_______\n|\n|\n|\n|\n|\n|\n";
                bytes = new byte[]{95, 95, 95, 95, 95, 95, 95, 10,
                        124, 10, 124, 10, 124, 10, 124, 10, 124, 10, 124, 10};
                return new String(bytes);
            }
            case (2): {
//                hang = "_______\n|     |\n|\n|\n|\n|\n|\n";
                bytes = new byte[]{95, 95, 95, 95, 95, 95, 95, 10,
                        124, 32, 32, 32, 32, 32, 124, 10,
                        124, 10, 124, 10, 124, 10, 124, 10, 124, 10, 124, 10};
                return new String(bytes);
            }
            case (1): {
//                hang = "_______\n|     |\n|     o\n|     ^\n|\n|\n|\n";
                bytes = new byte[]{95, 95, 95, 95, 95, 95, 95, 10,
                        124, 32, 32, 32, 32, 32, 124, 10,
                        124, 32, 32, 32, 32, 32, 111, 10,
                        124, 32, 32, 32, 32, 32, 94, 10,
                        124, 10, 124, 10, 124, 10};
                return new String(bytes);
            }
            case (0): {
//                hang = "_______\n|     |\n|     o\n|     ^\n|     |\n|     ^\n|\n";
                bytes = new byte[]{95, 95, 95, 95, 95, 95, 95, 10,
                        124, 32, 32, 32, 32, 32, 124, 10,
                        124, 32, 32, 32, 32, 32, 111, 10,
                        124, 32, 32, 32, 32, 32, 94, 10,
                        124, 32, 32, 32, 32, 32, 124, 10,
                        124, 32, 32, 32, 32, 32, 94, 10,
                        124, 10};
                return new String(bytes);
            }
        }
        return null;
    }
}
