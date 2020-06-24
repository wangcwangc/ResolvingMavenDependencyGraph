package neu.lab.data.po;

public class MavenDependency {
    private int id;
    private String groupId;
    private String artifactId;
    private String dependencyGroupId;
    private String dependencyArtifactId;

    public MavenDependency(String groupId, String artifactId) {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getDependencyGroupId() {
        return dependencyGroupId;
    }

    public void setDependencyGroupId(String dependencyGroupId) {
        this.dependencyGroupId = dependencyGroupId;
    }

    public String getDependencyArtifactId() {
        return dependencyArtifactId;
    }

    public void setDependencyArtifactId(String dependencyArtifactId) {
        this.dependencyArtifactId = dependencyArtifactId;
    }

    @Override
    public String toString() {
        return "MavenDependency{" +
            ", groupId='" + groupId + '\'' +
            ", artifactId='" + artifactId + '\'' +
            ", dependencyGroupId='" + dependencyGroupId + '\'' +
            ", dependencyArtifactId='" + dependencyArtifactId + '\'' +
            '}';
    }
}
