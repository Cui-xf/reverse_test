package androidx.compose.ui.text;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001af\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001ah\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aj\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a&\u00102\u001a\u000203*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPainterKt {
    /* renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m6125drawTextJFhB2K4(DrawScope $this$drawText_u2dJFhB2K4, TextMeasurer textMeasurer, AnnotatedString text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> list, long size, int blendMode) {
        TextLayoutResult textLayoutResult = TextMeasurer.m6122measurexDpz5zY$default(textMeasurer, text, style, overflow, softWrap, maxLines, list, m6133textLayoutConstraintsv_w8tDc($this$drawText_u2dJFhB2K4, size, topLeft), $this$drawText_u2dJFhB2K4.getLayoutDirection(), $this$drawText_u2dJFhB2K4, null, false, 1536, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dJFhB2K4.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4669getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$drawText_JFhB2K4_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$drawText_JFhB2K4_u24lambda_u240.translate(Offset.m3945getXimpl(topLeft), Offset.m3946getYimpl(topLeft));
            clip($this$drawText_JFhB2K4_u24lambda_u240, textLayoutResult);
            textLayoutResult.getMultiParagraph().m6015paintLG529CI($this$drawText_u2dJFhB2K4.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU() : blendMode);
        } finally {
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4670setSizeuvyYCjk(previousSize$iv);
        }
    }

    /* renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m6129drawTextTPWCCtM(DrawScope $this$drawText_u2dTPWCCtM, TextMeasurer textMeasurer, String text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, long size, int blendMode) {
        TextLayoutResult textLayoutResult = TextMeasurer.m6122measurexDpz5zY$default(textMeasurer, new AnnotatedString(text, null, null, 6, null), style, overflow, softWrap, maxLines, null, m6133textLayoutConstraintsv_w8tDc($this$drawText_u2dTPWCCtM, size, topLeft), $this$drawText_u2dTPWCCtM.getLayoutDirection(), $this$drawText_u2dTPWCCtM, null, false, 1568, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dTPWCCtM.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4669getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$drawText_TPWCCtM_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$drawText_TPWCCtM_u24lambda_u242.translate(Offset.m3945getXimpl(topLeft), Offset.m3946getYimpl(topLeft));
            clip($this$drawText_TPWCCtM_u24lambda_u242, textLayoutResult);
            textLayoutResult.getMultiParagraph().m6015paintLG529CI($this$drawText_u2dTPWCCtM.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU() : blendMode);
        } finally {
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4670setSizeuvyYCjk(previousSize$iv);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:15:0x005c, B:22:0x0082, B:26:0x00a4, B:25:0x0098, B:27:0x00b0, B:33:0x00df, B:32:0x00d0), top: B:42:0x005c }] */
    /* renamed from: drawText-d8-rzKo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m6131drawTextd8rzKo(androidx.compose.ui.graphics.drawscope.DrawScope r28, androidx.compose.ui.text.TextLayoutResult r29, long r30, long r32, float r34, androidx.compose.ui.graphics.Shadow r35, androidx.compose.ui.text.style.TextDecoration r36, androidx.compose.ui.graphics.drawscope.DrawStyle r37, int r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextPainterKt.m6131drawTextd8rzKo(androidx.compose.ui.graphics.drawscope.DrawScope, androidx.compose.ui.text.TextLayoutResult, long, long, float, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.drawscope.DrawStyle, int):void");
    }

    /* renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m6127drawTextLVfH_YU(DrawScope $this$drawText_u2dLVfH_YU, TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) throws Throwable {
        DrawTransform $this$drawText_LVfH_YU_u24lambda_u247;
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dLVfH_YU.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4669getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            $this$drawText_LVfH_YU_u24lambda_u247 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$drawText_LVfH_YU_u24lambda_u247.translate(Offset.m3945getXimpl(topLeft), Offset.m3946getYimpl(topLeft));
        } catch (Throwable th) {
            th = th;
        }
        try {
            clip($this$drawText_LVfH_YU_u24lambda_u247, textLayoutResult);
            textLayoutResult.getMultiParagraph().m6017painthn5TExg($this$drawText_u2dLVfH_YU.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4670setSizeuvyYCjk(previousSize$iv);
        } catch (Throwable th2) {
            th = th2;
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4670setSizeuvyYCjk(previousSize$iv);
            throw th;
        }
    }

    private static final void clip(DrawTransform $this$clip, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6592equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m6601getVisiblegIe3tQ8())) {
            DrawTransform.CC.m4807clipRectN_I0leg$default($this$clip, 0.0f, 0.0f, IntSize.m6867getWidthimpl(textLayoutResult.getSize()), IntSize.m6866getHeightimpl(textLayoutResult.getSize()), 0, 16, null);
        }
    }

    /* renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m6133textLayoutConstraintsv_w8tDc(DrawScope $this$textLayoutConstraints_u2dv_w8tDc, long size, long topLeft) {
        int maxWidth;
        int minWidth;
        int maxHeight;
        int minHeight;
        boolean isHeightNaN = true;
        boolean isWidthNaN = ((size > InlineClassHelperKt.UnspecifiedPackedFloats ? 1 : (size == InlineClassHelperKt.UnspecifiedPackedFloats ? 0 : -1)) == 0) || Float.isNaN(Size.m4014getWidthimpl(size));
        if (isWidthNaN) {
            minWidth = 0;
            float $this$fastRoundToInt$iv = (float) Math.ceil(Size.m4014getWidthimpl($this$textLayoutConstraints_u2dv_w8tDc.mo4662getSizeNHjbRc()) - Offset.m3945getXimpl(topLeft));
            maxWidth = Math.round($this$fastRoundToInt$iv);
        } else {
            float $this$fastRoundToInt$iv2 = (float) Math.ceil(Size.m4014getWidthimpl(size));
            maxWidth = Math.round($this$fastRoundToInt$iv2);
            minWidth = maxWidth;
        }
        if (!(size == InlineClassHelperKt.UnspecifiedPackedFloats) && !Float.isNaN(Size.m4011getHeightimpl(size))) {
            isHeightNaN = false;
        }
        if (isHeightNaN) {
            minHeight = 0;
            float $this$fastRoundToInt$iv3 = (float) Math.ceil(Size.m4011getHeightimpl($this$textLayoutConstraints_u2dv_w8tDc.mo4662getSizeNHjbRc()) - Offset.m3946getYimpl(topLeft));
            maxHeight = Math.round($this$fastRoundToInt$iv3);
        } else {
            float $this$fastRoundToInt$iv4 = (float) Math.ceil(Size.m4011getHeightimpl(size));
            maxHeight = Math.round($this$fastRoundToInt$iv4);
            minHeight = maxHeight;
        }
        return ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
    }
}
