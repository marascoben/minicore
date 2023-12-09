package register;

public enum IXR {
    NOX((byte) 0b000),
    IX1((byte) 0b001),
    IX2((byte) 0b010),
    IX3((byte) 0b011);

    public final byte id;

    private IXR(byte id) {
        this.id = id;
    }

    /**
     * Returns the IXR with the given id.
     * 
     * @param id the id of the IXR
     * @return the IXR with the given id
     */
    public static IXR getIXR(byte id) {
        for (IXR ixr : IXR.values()) {
            if (ixr.id == id) {
                return ixr;
            }
        }

        return null;
    }
}
