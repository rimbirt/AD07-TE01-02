package eus.birt.ad7.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Crag {
    @Id
    private String id;

    @NotBlank
    private String name;

    private Set<Route> routes = new HashSet<>();

    @Builder
    public Crag(String id, String name, Set<Route> routes) {
        this.id = id;
        this.name = name;
        this.routes = routes;
    }
}
