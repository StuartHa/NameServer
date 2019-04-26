class ResourceRecord {
    private int type;
    private int ttl;

    protected ResourceRecord(int type, int ttl) {
        this.type = type;
        this.ttl = ttl;
    }

    public int getType() {
        return type;
    }

    public int getTtl() {
        return ttl;
    }
}