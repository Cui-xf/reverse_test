package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J$\u0010\u0016\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final Function0<RippleAlpha> rippleAlpha;
    private final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List<Interaction> interactions = new ArrayList();

    public StateLayer(boolean bounded, Function0<RippleAlpha> function0) {
        this.bounded = bounded;
        this.rippleAlpha = function0;
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, CoroutineScope scope) {
        float targetAlpha;
        if (interaction instanceof HoverInteraction.Enter) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (interaction instanceof DragInteraction.Cancel) {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        } else {
            return;
        }
        Interaction newInteraction = (Interaction) CollectionsKt.lastOrNull((List) this.interactions);
        if (!Intrinsics.areEqual(this.currentInteraction, newInteraction)) {
            if (newInteraction == null) {
                AnimationSpec outgoingAnimationSpec = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$2(this, outgoingAnimationSpec, null), 3, null);
            } else {
                RippleAlpha rippleAlpha = this.rippleAlpha.invoke();
                if (interaction instanceof HoverInteraction.Enter) {
                    targetAlpha = rippleAlpha.getHoveredAlpha();
                } else if (interaction instanceof FocusInteraction.Focus) {
                    targetAlpha = rippleAlpha.getFocusedAlpha();
                } else {
                    targetAlpha = interaction instanceof DragInteraction.Start ? rippleAlpha.getDraggedAlpha() : 0.0f;
                }
                AnimationSpec incomingAnimationSpec = RippleKt.incomingStateLayerAnimationSpecFor(newInteraction);
                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(this, targetAlpha, incomingAnimationSpec, null), 3, null);
            }
            this.currentInteraction = newInteraction;
        }
    }

    /* renamed from: drawStateLayer-mxwnekA, reason: not valid java name */
    public final void m1771drawStateLayermxwnekA(DrawScope $this$drawStateLayer_u2dmxwnekA, float radius, long color) {
        float alpha = this.animatedAlpha.getValue().floatValue();
        if (alpha > 0.0f) {
            long modulatedColor = Color.m4185copywmQWz5c(color, (14 & 1) != 0 ? Color.m4189getAlphaimpl(color) : alpha, (14 & 2) != 0 ? Color.m4193getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(color) : 0.0f);
            if (!this.bounded) {
                DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawStateLayer_u2dmxwnekA, modulatedColor, radius, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float right$iv = Size.m4014getWidthimpl($this$drawStateLayer_u2dmxwnekA.mo4662getSizeNHjbRc());
            float bottom$iv = Size.m4011getHeightimpl($this$drawStateLayer_u2dmxwnekA.mo4662getSizeNHjbRc());
            int clipOp$iv = ClipOp.INSTANCE.m4176getIntersectrtfAjoo();
            DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$drawStateLayer_u2dmxwnekA.getDrawContext();
            long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4669getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
            $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4672clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
            DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawStateLayer_u2dmxwnekA, modulatedColor, radius, 0L, 0.0f, null, null, 0, 124, null);
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
        }
    }
}
