package ggxnet.reload.client;

import ggxnet.reload.service.LobbyService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
class LobbyRestController {

    private final LobbyService lobbyService;

    @GetMapping
    public void handleGet(HttpServletRequest httpServletRequest) {
        lobbyService.processGet(getRequest(httpServletRequest));
    }

    @PostMapping
    public void handlePost(HttpServletRequest httpServletRequest) {
        lobbyService.processPost(getRequest(httpServletRequest),httpServletRequest.getRemoteAddr());
    }

    @SneakyThrows
    private String getRequest(HttpServletRequest httpServletRequest) {
        var httpMethodName = httpServletRequest.getMethod();
        log.info("--------" + httpMethodName + "--------");
        var request = httpServletRequest.getReader()
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
        log.info("Request: {}", request);
        return request;
    }

}