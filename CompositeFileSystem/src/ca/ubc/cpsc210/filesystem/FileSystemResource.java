package ca.ubc.cpsc210.filesystem;

// Represents a file system resource
public abstract class FileSystemResource {
	protected String name;
    private static final String TAB = "   ";

    public FileSystemResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print() {
        print(0);
    }

    protected void printIndent (int indent) {
        String indentation = "";

        for (int i = 0; i < indent; i++ ) {
            indentation += TAB;
        }
        System.out.print(indentation);
    }

    /**
     * Prints the tree rooted at this file system resource.
     */
	protected abstract void print(int indent);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileSystemResource that = (FileSystemResource) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
