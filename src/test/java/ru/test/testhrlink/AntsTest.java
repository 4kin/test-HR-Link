package ru.test.testhrlink;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AntsTest {

    @Test
    void runAnts() {
        Ants ants = new Ants();

        Assertions.assertThat(ants.runAnts(4, 1, 3)).isEqualTo(2);
        Assertions.assertThat(ants.runAnts(4, 4, 1)).isEqualTo(3);
        Assertions.assertThat(ants.runAnts(4, 4, 3)).isEqualTo(1);
        Assertions.assertThat(ants.runAnts(3, 3, 1)).isEqualTo(2);
        Assertions.assertThat(ants.runAnts(100, 98, 5)).isEqualTo(95);
        Assertions.assertThat(ants.runAnts(3, 3, 1)).isEqualTo(2);
    }
}