package org.siit.week9;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Veteran
{
    @NonNull
    String name;

    @NonNull
    int age;

    @NonNull
    int experience = 0;

    public Veteran(Veteran v) {
        this.name = v.getName();
        this.age = v.getAge();
    }
}
