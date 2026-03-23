package androidx.compose.material.ripple;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ripple.android.kt */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformRipple extends Ripple {
    public static final int $stable = 0;

    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    private PlatformRipple(boolean bounded, float radius, State<Color> state) {
        super(bounded, radius, state, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    @Override // androidx.compose.material.ripple.Ripple
    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.material.ripple.RippleIndicationInstance mo1756rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource r18, boolean r19, float r20, androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r21, androidx.compose.runtime.State<androidx.compose.material.ripple.RippleAlpha> r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            r17 = this;
            r0 = r23
            r1 = r24
            r2 = 331259447(0x13be9e37, float:4.8118755E-27)
            r0.startReplaceGroup(r2)
            java.lang.String r3 = "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)93@3647L7,94@3671L138:Ripple.android.kt#vhb33q"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L1b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:92)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L1b:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r6)
            java.lang.Object r5 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.view.View r5 = (android.view.View) r5
            android.view.ViewGroup r11 = androidx.compose.material.ripple.Ripple_androidKt.access$findNearestViewGroup(r5)
            r2 = -598285110(0xffffffffdc56e4ca, float:-2.419488E17)
            java.lang.String r3 = "CC(remember):Ripple.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            r2 = r1 & 14
            r2 = r2 ^ 6
            r3 = 0
            r4 = 1
            r5 = 4
            if (r2 <= r5) goto L52
            r2 = r18
            boolean r6 = r0.changed(r2)
            if (r6 != 0) goto L58
            goto L54
        L52:
            r2 = r18
        L54:
            r6 = r1 & 6
            if (r6 != r5) goto L5a
        L58:
            r5 = 1
            goto L5b
        L5a:
            r5 = 0
        L5b:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r1
            r7 = 196608(0x30000, float:2.75506E-40)
            r6 = r6 ^ r7
            r8 = 131072(0x20000, float:1.83671E-40)
            if (r6 <= r8) goto L6e
            r13 = r17
            boolean r6 = r0.changed(r13)
            if (r6 != 0) goto L74
            goto L70
        L6e:
            r13 = r17
        L70:
            r6 = r1 & r7
            if (r6 != r8) goto L75
        L74:
            r3 = 1
        L75:
            r3 = r3 | r5
            boolean r4 = r0.changed(r11)
            r3 = r3 | r4
            r4 = r23
            r5 = 0
            java.lang.Object r14 = r4.rememberedValue()
            r15 = 0
            if (r3 != 0) goto L90
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r6 = r6.getEmpty()
            if (r14 != r6) goto L8e
            goto L90
        L8e:
            r6 = r14
            goto La5
        L90:
            r16 = 0
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r6 = new androidx.compose.material.ripple.AndroidRippleIndicationInstance
            r12 = 0
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r4.updateRememberedValue(r6)
        La5:
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r6 = (androidx.compose.material.ripple.AndroidRippleIndicationInstance) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto Lb5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lb5:
            r0.endReplaceGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r6 = (androidx.compose.material.ripple.RippleIndicationInstance) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.PlatformRipple.mo1756rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource, boolean, float, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):androidx.compose.material.ripple.RippleIndicationInstance");
    }
}
