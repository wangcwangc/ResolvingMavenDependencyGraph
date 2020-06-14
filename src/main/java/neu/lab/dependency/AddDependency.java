package neu.lab.dependency;

import neu.lab.container.NodeAdapters;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "addDependency", defaultPhase = LifecyclePhase.VALIDATE)
public class AddDependency extends DependencyMojo {
    @Override
    public void run() {
        NodeAdapters.init(root);
    }
}
