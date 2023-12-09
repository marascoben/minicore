package register;

public enum GPR {
    GPR0((byte) 0b000),
    GPR1((byte) 0b001),
    GPR2((byte) 0b010),
    GPR3((byte) 0b011);

    public final byte id;

    private GPR(byte id) {
        this.id = id;
    }

    /**
     * Returns the GPR with the given id.
     * 
     * @param id the id of the GPR
     * @return the GPR with the given id
     */
    public static GPR fromId(byte id) {
        for (GPR gpr : GPR.values()) {
            if (gpr.id == id) {
                return gpr;
            }
        }

        return null;
    }
}
