package net.hyunu.christmas.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.hyunu.christmas.Hyunu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;

public class ThirstHudOverlay implements HudRenderCallback {

    private static final Identifier HUD_BACKGROUND = new Identifier(Hyunu.MOD_ID, "textures/thirst/hud_background.png");
    private static final Identifier EMPTY_THIRST = new Identifier(Hyunu.MOD_ID, "textures/thirst/empty_thirst.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            // 화면 크기 가져오기
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            // 원본 텍스처 크기 (16x16)
            int textureWidth = 585;
            int textureHeight = 207;

            // 화면에 맞는 크기 계산
            float scaleFactorX = width / 1920f; // 1920은 기본 해상도
            float scaleFactorY = height / 1080f; // 1080은 기본 해상도

            // 텍스처 크기 조정: 화면 해상도에 맞춰 크기 계산
            int scaledWidth = (int) (textureWidth * scaleFactorX * 1); // 배율 조정: '2'로 배율을 키워서 더 크게 출력
            int scaledHeight = (int) (textureHeight * scaleFactorY * 1); // 세로 크기도 배율을 키워서 더 크게 출력

            drawContext.drawTexture(HUD_BACKGROUND, 0, 0, scaledWidth, scaledHeight, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);

            TextRenderer textRenderer = client.textRenderer;

            MatrixStack matrices = drawContext.getMatrices();
            matrices.push();  // MatrixStack 저장
            matrices.scale(scaleFactorX * 10, scaleFactorY * 10, 1.0f);  // X와 Y 축에 동일한 스케일 적용 (Z는 1.0으로 고정)
            Text sans = Text.literal("Hello, world!")
                    .setStyle(Style.EMPTY
                            .withBold(false)  // 볼드체로 약간 더 크게 보이게
                    );
            drawContext.drawTextWithShadow(textRenderer, sans, 0, 0, 0xFFFFFF);
            matrices.pop();  // MatrixStack 복원

            // 텍스처를 좌측 상단(0, 0) 위치에 그리기

        }
    }
}
