package run.var.teamcity.cloud.docker.web;

import org.junit.Test;
import run.var.teamcity.cloud.docker.client.DockerClientConfig;
import run.var.teamcity.cloud.docker.util.DockerCloudUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * {@łink ContainerCoordinates} test suite.
 */
public class ContainerCoordinatesTest {

    @Test
    public void getters() {

        DockerClientConfig clientConfig = new DockerClientConfig(DockerCloudUtils.DOCKER_DEFAULT_SOCKET_URI,
                DockerCloudUtils.DOCKER_API_TARGET_VERSION);

        ContainerCoordinates coordinates = new ContainerCoordinates("test", clientConfig);

        assertThat(coordinates.getClientConfig()).isSameAs(clientConfig);
        assertThat(coordinates.getContainerId()).isEqualTo("test");
    }

    @Test
    public void invalidInput() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() ->
                new ContainerCoordinates("test", null));

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() ->
                new ContainerCoordinates(null,
                        new DockerClientConfig(DockerCloudUtils.DOCKER_DEFAULT_SOCKET_URI,
                                DockerCloudUtils.DOCKER_API_TARGET_VERSION)));
    }
}