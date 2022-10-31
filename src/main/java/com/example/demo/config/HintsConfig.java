package com.example.demo.config;

import com.example.demo.config.HintsConfig.DemoRuntimeHintRegistrar;
import java.math.BigDecimal;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(DemoRuntimeHintRegistrar.class)
@Configuration
public class HintsConfig {

    static class DemoRuntimeHintRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerType(BigDecimal.class);
            try {
                hints.reflection()
                        .registerConstructor(BigDecimal.class.getConstructor(String.class), ExecutableMode.INVOKE);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
