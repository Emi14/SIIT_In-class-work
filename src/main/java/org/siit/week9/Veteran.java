package org.siit.week9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class Veteran
{
    @NonNull
    String name;

    @NonNull
    int age;

    public Veteran(Veteran v) {
        this.name = v.getName();
        this.age = v.getAge();
    }
}
