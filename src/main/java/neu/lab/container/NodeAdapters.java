package neu.lab.container;

import neu.lab.data.dao.MavenDependencyDao;
import neu.lab.data.po.MavenDependency;
import neu.lab.util.Config;
import neu.lab.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.maven.shared.dependency.tree.DependencyNode;

/**
 * @author wangchao
 */
public class NodeAdapters {

    public static void init(DependencyNode root) {
        MavenDependency mavenDependency = new MavenDependency(root.getArtifact().getGroupId(), root.getArtifact().getArtifactId());
        for (DependencyNode childDirect : root.getChildren()) {
            mavenDependency.setDependencyGroupId(childDirect.getArtifact().getGroupId());
            mavenDependency.setDependencyArtifactId(childDirect.getArtifact().getArtifactId());
            insertMavenDependency(mavenDependency);
            addIndirectArtifactNodes(childDirect, 2);
        }
    }

    private static void addIndirectArtifactNodes(DependencyNode dependencyNode, int depth) {
        if (depth <= Config.maxDependencyDepth) {
            depth = depth + 1;
            MavenDependency mavenDependency = new MavenDependency(dependencyNode.getArtifact().getGroupId(), dependencyNode.getArtifact().getArtifactId());
            for (DependencyNode child : dependencyNode.getChildren()) {
                mavenDependency.setDependencyGroupId(child.getArtifact().getGroupId());
                mavenDependency.setDependencyArtifactId(child.getArtifact().getArtifactId());
                insertMavenDependency(mavenDependency);
                addIndirectArtifactNodes(child, depth);
            }
        }
    }

    private static void insertMavenDependency(MavenDependency mavenDependency) {
//        SqlSession sqlSession = MybatisUtil.createSqlSession();
//        MavenDependencyDao mavenDependencyDao = sqlSession.getMapper(MavenDependencyDao.class);
//        if (mavenDependencyDao.isExist(mavenDependency) == 0) {
//            mavenDependencyDao.insertMavenDependency(mavenDependency);
//            sqlSession.commit();
//        }
//        MybatisUtil.closeSqlSession(sqlSession);
        System.out.println(mavenDependency.toString());
    }
}
