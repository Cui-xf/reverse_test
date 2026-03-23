package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* compiled from: CanvasDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext $this$asDrawTransform) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo4674getSizeNHjbRc() {
                return $this$asDrawTransform.mo4669getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo4673getCenterF1C5BW0() {
                return SizeKt.m4024getCenteruvyYCjk(mo4674getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas it = $this$asDrawTransform.getCanvas();
                DrawContext drawContext = $this$asDrawTransform;
                long updatedSize = SizeKt.Size(Size.m4014getWidthimpl(mo4674getSizeNHjbRc()) - (left + right), Size.m4011getHeightimpl(mo4674getSizeNHjbRc()) - (top + bottom));
                boolean value$iv = Size.m4014getWidthimpl(updatedSize) >= 0.0f && Size.m4011getHeightimpl(updatedSize) >= 0.0f;
                if (!value$iv) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext.mo4670setSizeuvyYCjk(updatedSize);
                it.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo4672clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                $this$asDrawTransform.getCanvas().mo4040clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo4671clipPathmtrdDE(Path path, int clipOp) {
                $this$asDrawTransform.getCanvas().mo4039clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                $this$asDrawTransform.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo4675rotateUv8p0NA(float degrees, long pivot) {
                Canvas $this$rotate_Uv8p0NA_u24lambda_u242 = $this$asDrawTransform.getCanvas();
                $this$rotate_Uv8p0NA_u24lambda_u242.translate(Offset.m3945getXimpl(pivot), Offset.m3946getYimpl(pivot));
                $this$rotate_Uv8p0NA_u24lambda_u242.rotate(degrees);
                $this$rotate_Uv8p0NA_u24lambda_u242.translate(-Offset.m3945getXimpl(pivot), -Offset.m3946getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo4676scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas $this$scale_0AR0LA0_u24lambda_u243 = $this$asDrawTransform.getCanvas();
                $this$scale_0AR0LA0_u24lambda_u243.translate(Offset.m3945getXimpl(pivot), Offset.m3946getYimpl(pivot));
                $this$scale_0AR0LA0_u24lambda_u243.scale(scaleX, scaleY);
                $this$scale_0AR0LA0_u24lambda_u243.translate(-Offset.m3945getXimpl(pivot), -Offset.m3946getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo4677transform58bKbWc(float[] matrix) {
                $this$asDrawTransform.getCanvas().mo4042concat58bKbWc(matrix);
            }
        };
    }
}
