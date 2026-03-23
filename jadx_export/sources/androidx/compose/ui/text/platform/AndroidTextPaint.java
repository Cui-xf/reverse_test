package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00107\u001a\u000208H\u0002J,\u00109\u001a\u0002082\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010:\u001a\u00020\u001b2\b\b\u0002\u0010;\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u0002082\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u0002082\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010E\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010&\u001a\u0012\u0012\f\u0012\n\u0018\u00010(j\u0004\u0018\u0001`)\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020/8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text_release", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text_release", "(Landroidx/compose/runtime/State;)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "clearShader", "", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private State<? extends Shader> shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public static /* synthetic */ void getBrush$ui_text_release$annotations() {
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release$annotations, reason: not valid java name */
    public static /* synthetic */ void m6408getBrushSizeVsRJwc0$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int flags, float density) {
        super(flags);
        this.density = density;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.backingBlendMode = DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    private final Paint getComposePaint() {
        Paint finalBackingComposePaint = this.backingComposePaint;
        if (finalBackingComposePaint != null) {
            return finalBackingComposePaint;
        }
        Paint it = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = it;
        return it;
    }

    /* renamed from: getShadow$ui_text_release, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    public final void setShadow$ui_text_release(Shadow shadow) {
        this.shadow = shadow;
    }

    /* renamed from: getBrush$ui_text_release, reason: from getter */
    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush$ui_text_release(Brush brush) {
        this.brush = brush;
    }

    public final State<Shader> getShaderState$ui_text_release() {
        return this.shaderState;
    }

    public final void setShaderState$ui_text_release(State<? extends Shader> state) {
        this.shaderState = state;
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release, reason: not valid java name and from getter */
    public final Size getBrushSize() {
        return this.brushSize;
    }

    /* renamed from: setBrushSize-iaC8Vc4$ui_text_release, reason: not valid java name */
    public final void m6414setBrushSizeiaC8Vc4$ui_text_release(Size size) {
        this.brushSize = size;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration != null && !Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            this.textDecoration = textDecoration;
            setUnderlineText(this.textDecoration.contains(TextDecoration.INSTANCE.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow) {
        if (shadow != null && !Intrinsics.areEqual(this.shadow, shadow)) {
            this.shadow = shadow;
            if (Intrinsics.areEqual(this.shadow, Shadow.INSTANCE.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m3945getXimpl(this.shadow.getOffset()), Offset.m3946getYimpl(this.shadow.getOffset()), ColorKt.m4241toArgb8_81llA(this.shadow.getColor()));
            }
        }
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m6415setColor8_81llA(long color) {
        if (color != 16) {
            setColor(ColorKt.m4241toArgb8_81llA(color));
            clearShader();
        }
    }

    /* renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m6409setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m6413setBrush12SF9DM(brush, j, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6413setBrush12SF9DM(final androidx.compose.ui.graphics.Brush r8, final long r9, float r11) {
        /*
            r7 = this;
            if (r8 != 0) goto L7
            r7.clearShader()
            goto L73
        L7:
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.SolidColor
            if (r0 == 0) goto L1a
            r0 = r8
            androidx.compose.ui.graphics.SolidColor r0 = (androidx.compose.ui.graphics.SolidColor) r0
            long r0 = r0.getValue()
            long r0 = androidx.compose.ui.text.style.TextDrawStyleKt.m6570modulateDxMtmZc(r0, r11)
            r7.m6415setColor8_81llA(r0)
            goto L73
        L1a:
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L73
            androidx.compose.ui.graphics.Brush r0 = r7.brush
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            r1 = 0
            if (r0 == 0) goto L37
            androidx.compose.ui.geometry.Size r0 = r7.brushSize
            if (r0 != 0) goto L2d
            r0 = 0
            goto L35
        L2d:
            long r2 = r0.getPackedValue()
            boolean r0 = androidx.compose.ui.geometry.Size.m4010equalsimpl0(r2, r9)
        L35:
            if (r0 != 0) goto L5a
        L37:
            r2 = r9
            r0 = 0
            r4 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L43
            r1 = 1
        L43:
            if (r1 == 0) goto L5a
            r7.brush = r8
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.m4002boximpl(r9)
            r7.brushSize = r0
            androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1 r0 = new androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
            r0.<init>()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r7.shaderState = r0
        L5a:
            androidx.compose.ui.graphics.Paint r0 = r7.getComposePaint()
            androidx.compose.runtime.State<? extends android.graphics.Shader> r1 = r7.shaderState
            if (r1 == 0) goto L69
            java.lang.Object r1 = r1.getValue()
            android.graphics.Shader r1 = (android.graphics.Shader) r1
            goto L6a
        L69:
            r1 = 0
        L6a:
            r0.setShader(r1)
            r0 = r7
            android.text.TextPaint r0 = (android.text.TextPaint) r0
            androidx.compose.ui.text.platform.AndroidTextPaint_androidKt.setAlpha(r0, r11)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m6413setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle != null && !Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            this.drawStyle = drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                getComposePaint().mo4070setStylek9PVt8s(PaintingStyle.INSTANCE.m4461getStrokeTiuSbCo());
                getComposePaint().setStrokeWidth(((Stroke) drawStyle).getWidth());
                getComposePaint().setStrokeMiterLimit(((Stroke) drawStyle).getMiter());
                getComposePaint().mo4069setStrokeJoinWw9F2mQ(((Stroke) drawStyle).getJoin());
                getComposePaint().mo4068setStrokeCapBeK7IIE(((Stroke) drawStyle).getCap());
                getComposePaint().setPathEffect(((Stroke) drawStyle).getPathEffect());
            }
        }
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBackingBlendMode() {
        return this.backingBlendMode;
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m6412setBlendModes9anfk8(int value) {
        if (BlendMode.m4098equalsimpl0(value, this.backingBlendMode)) {
            return;
        }
        getComposePaint().mo4065setBlendModes9anfk8(value);
        this.backingBlendMode = value;
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }
}
