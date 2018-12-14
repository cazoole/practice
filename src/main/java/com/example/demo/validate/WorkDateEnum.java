package com.example.demo.validate;

public enum WorkDateEnum {
    SUNDAY("0", "星期日"),
    MONDAY("1", "星期一"),
    TUESDAY("2", "星期二"),
    WEDNESDAY("3", "星期三"),
    THURSDAY("4", "星期四"),
    FRIDAY("5", "星期五"),
    SATURDAY("6", "星期六");

    private String code;
    private String desc;

    WorkDateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static WorkDateEnum valueByCode(String code) {
        for (WorkDateEnum workDateEnum : WorkDateEnum.values()) {
            if(workDateEnum.getCode().equals(code)) {
                return workDateEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkDateEnum{");
        sb.append("code='").append(code).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
