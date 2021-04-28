package com.example.carrentaldemo.business.domain;

public enum Color {
    BLACK(0),WHITE(1),RED(2),YELLOW(3);

    private int code;

    private Color(int code) {
        this.code = code;
    }

    public static Color convert(Integer code){
        if (code==null)
            return null;
        switch (code) {
            case 0: return BLACK;
            case 1: return WHITE;
            case 2: return RED;
            case 3: return YELLOW;


        }
        throw new IllegalArgumentException(code+ " is not defined for Color enum");
    }



    public Integer code() {

        return code;
    }

}
