package eus.birt.ad7.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Climber {

    @Id
    private String id;

    @NotBlank
    private String name;

    private String lastName;

    private Set<Ascend> ascends = new HashSet<>();

}
