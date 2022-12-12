package ggxnet.reload.service.dto;

import java.io.Serializable;

public record RGBa(
        short R,
        short G,
        short B,
        short a) implements Serializable {
}