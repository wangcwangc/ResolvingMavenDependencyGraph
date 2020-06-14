package neu.lab.util;

import neu.lab.dependency.DependencyMojo;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.resolver.ArtifactNotFoundException;
import org.apache.maven.artifact.resolver.ArtifactResolutionException;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MavenUtil {
    private static MavenUtil instance = new MavenUtil();
    private Set<String> hostClses;

    public static MavenUtil i() {
        return instance;
    }

    private MavenUtil() {

    }

    private DependencyMojo mojo;

//    public boolean isInner(NodeAdapter nodeAdapter) {
//        return nodeAdapter.isSelf(mojo.project);
//        // for (MavenProject mavenProject : mojo.reactorProjects) {
//        // if (nodeAdapter.isSelf(mavenProject))
//        // return true;
//        // }
//        // return false;
//    }
//
//    public MavenProject getMavenProject(NodeAdapter nodeAdapter) {
//        for (MavenProject mavenProject : mojo.reactorProjects) {
//            if (nodeAdapter.isSelf(mavenProject))
//                return mavenProject;
//        }
//        return null;
//    }

    public void setMojo(DependencyMojo mojo) {
        this.mojo = mojo;
    }

    public void resolve(Artifact artifact) throws ArtifactResolutionException, ArtifactNotFoundException {
        mojo.resolver.resolve(artifact, mojo.remoteRepositories, mojo.localRepository);
    }

    public Log getLog() {
        return mojo.getLog();
    }

    public Artifact getArtifact(String groupId, String artifactId, String versionRange, String type, String classifier,
                                String scope) {
        try {
            return mojo.factory.createDependencyArtifact(groupId, artifactId,
                    VersionRange.createFromVersionSpec(versionRange), type, classifier, scope);
        } catch (InvalidVersionSpecificationException e) {
            getLog().error("cant create MavenArtifact!", e);
            return null;
        }
    }


    public String getProjectInfo() {
        return mojo.project.getGroupId() + ":" + mojo.project.getArtifactId() + ":" + mojo.project.getVersion() + "@"
                + mojo.project.getFile().getAbsolutePath();
    }

    /**
     * 得到项目pom.xml的位置
     *
     * @return
     */
    public String getProjectPom() {
        return mojo.project.getFile().getAbsolutePath();
    }

    public String getProjectCor() {
        return mojo.project.getGroupId() + ":" + mojo.project.getArtifactId() + ":" + mojo.project.getVersion();
    }

    public String getProjectGroupId() {
        return mojo.project.getGroupId();
    }

    public String getProjectArtifactId() {
        return mojo.project.getArtifactId();
    }

    public String getProjectVersion() {
        return mojo.project.getVersion();
    }

    public DependencyMojo getMojo() {
        return mojo;
    }

    /**
     * D:\cWS\eclipse1\testcase.top
     *
     * @return
     */
    public File getBaseDir() {
        return mojo.project.getBasedir();
    }

    public File getBuildDir() {
        return mojo.buildDir;
    }

    public List<String> getSrcPaths() {
        List<String> srcPaths = new ArrayList<String>();
        if (this.mojo == null) {
            return null;
        }
        for (String srcPath : this.mojo.compileSourceRoots) {
            if (new File(srcPath).exists())
                srcPaths.add(srcPath);
        }
        return srcPaths;
    }

    public String getMvnRep() {
        return this.mojo.localRepository.getBasedir() + "\\";
    }
}
