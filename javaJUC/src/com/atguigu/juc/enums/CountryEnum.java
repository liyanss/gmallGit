package com.atguigu.juc.enums;

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),ThREE(3,"燕"),FOR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");


    private int code;
    private String massage;

    CountryEnum(int code, String massage) {
        this.code=code;
        this.massage=massage;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }
    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] values = CountryEnum.values();
        for(CountryEnum cou:values){
            if(index==cou.code){
                return cou;
            }
        }
        return null;
    }

}
