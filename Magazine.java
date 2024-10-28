class Magazine extends LibraryItem {
    private String issueDate;

    public Magazine(String id, String title, String issueDate) {
        super(id, title);
        this.issueDate = issueDate;
    }

    @Override
    public String getDetails() {
        return "Magazine (Issue Date: " + issueDate + ")";
    }

    @Override
    public boolean isAvailable() {
        return true; // Magazines are always available for reading
    }
}