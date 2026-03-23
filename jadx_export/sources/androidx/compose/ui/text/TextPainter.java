package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.ui.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.geometry.Rect] */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        ?? M3985Recttz77jQw;
        Canvas canvas2;
        long color;
        float alpha;
        boolean needClipping = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6592equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m6601getVisiblegIe3tQ8());
        if (needClipping) {
            float width = IntSize.m6867getWidthimpl(textLayoutResult.getSize());
            float height = IntSize.m6866getHeightimpl(textLayoutResult.getSize());
            M3985Recttz77jQw = RectKt.m3985Recttz77jQw(Offset.INSTANCE.m3961getZeroF1C5BW0(), SizeKt.Size(width, height));
            canvas.save();
            Canvas.CC.m4161clipRectmtrdDE$default(canvas, M3985Recttz77jQw, 0, 2, null);
        }
        SpanStyle style = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        Fill drawStyle = style.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            Brush brush = style.getBrush();
            try {
                if (brush != null) {
                    if (style.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                        try {
                            alpha = style.getTextForegroundStyle().getAlpha();
                        } catch (Throwable th) {
                            th = th;
                            M3985Recttz77jQw = canvas;
                            if (needClipping) {
                                M3985Recttz77jQw.restore();
                            }
                            throw th;
                        }
                    } else {
                        alpha = 1.0f;
                    }
                    canvas2 = canvas;
                    textLayoutResult.getMultiParagraph().m6017painthn5TExg(canvas2, brush, (64 & 4) != 0 ? Float.NaN : alpha, (64 & 8) != 0 ? null : shadow2, (64 & 16) != 0 ? null : textDecoration2, (64 & 32) != 0 ? null : drawStyle2, (64 & 64) != 0 ? DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU() : 0);
                } else {
                    canvas2 = canvas;
                    if (style.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                        color = style.getTextForegroundStyle().mo6448getColor0d7_KjU();
                    } else {
                        color = Color.INSTANCE.m4213getBlack0d7_KjU();
                    }
                    textLayoutResult.getMultiParagraph().m6015paintLG529CI(canvas2, (32 & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : color, (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU() : 0);
                }
                if (needClipping) {
                    canvas2.restore();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            M3985Recttz77jQw = canvas;
        }
    }
}
