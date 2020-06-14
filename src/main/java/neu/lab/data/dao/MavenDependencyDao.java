package neu.lab.data.dao;

import neu.lab.data.po.MavenDependency;

public interface MavenDependencyDao {
    void insertMavenDependency(MavenDependency mavenDependency);

    int isExist(MavenDependency mavenDependency);
}
