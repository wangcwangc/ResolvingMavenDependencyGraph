package neu.lab.dependency;

import neu.lab.operation.ChangeDependencyOperation;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "changeDependency", defaultPhase = LifecyclePhase.VALIDATE)
public class ChangeDependency extends DependencyMojo {
    @Override
    public void run() {
        new ChangeDependencyOperation().executeOperation();
    }
}
