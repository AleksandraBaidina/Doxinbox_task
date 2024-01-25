package common.enums;

public enum OrderTypes {

    A_Z("az"),
    Z_A("za"),
    LO_HI("lohi"),
    HI_LO("hilo");

    public final String value;

    OrderTypes(String value) {
        this.value = value;
    }
}
