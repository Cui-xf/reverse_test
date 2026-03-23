package androidx.compose.material3;

import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NavigationDrawer.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003¨\u0006\u0012"}, d2 = {"PredictiveBackDrawerMaxScaleXDistanceGrow", "Landroidx/compose/ui/unit/Dp;", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "DrawerPredictiveBackHandler", "", "drawerState", "Landroidx/compose/material3/DrawerState;", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/DrawerPredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationDrawer_androidKt {
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m6693constructorimpl(12);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m6693constructorimpl(24);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m6693constructorimpl(48);

    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv$iv;
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 value$iv2;
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1 value$iv3;
        Composer $composer2 = $composer.startRestartGroup(1444817207);
        ComposerKt.sourceInformation($composer2, "C(DrawerPredictiveBackHandler)P(1)45@1743L40,46@1800L24,47@1862L7,*51@2024L7,57@2337L1264,57@2285L1316,89@3644L99,89@3607L136,95@3749L34:NavigationDrawer.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(drawerState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444817207, $dirty2, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.android.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 228403032, "CC(remember):NavigationDrawer.android.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new DrawerPredictiveBackState();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            DrawerPredictiveBackState drawerPredictiveBackState = (DrawerPredictiveBackState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean isRtl = objConsume == LayoutDirection.Rtl;
            Ref.FloatRef maxScaleXDistanceGrow = new Ref.FloatRef();
            Ref.FloatRef maxScaleXDistanceShrink = new Ref.FloatRef();
            Ref.FloatRef maxScaleYDistance = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$DrawerPredictiveBackHandler_u24lambda_u241 = (Density) objConsume2;
            maxScaleXDistanceGrow.element = $this$DrawerPredictiveBackHandler_u24lambda_u241.mo367toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            maxScaleXDistanceShrink.element = $this$DrawerPredictiveBackHandler_u24lambda_u241.mo367toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            maxScaleYDistance.element = $this$DrawerPredictiveBackHandler_u24lambda_u241.mo367toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean zIsOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart($composer2, 228423264, "CC(remember):NavigationDrawer.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(isRtl) | $composer2.changed(maxScaleXDistanceGrow.element) | $composer2.changed(maxScaleXDistanceShrink.element) | $composer2.changed(maxScaleYDistance.element) | $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, scope, drawerState, isRtl, maxScaleXDistanceGrow, maxScaleXDistanceShrink, maxScaleYDistance, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PredictiveBackHandlerKt.PredictiveBackHandler(zIsOpen, (Function2) value$iv2, $composer2, 0, 0);
            Boolean boolValueOf = Boolean.valueOf(drawerState.isClosed());
            ComposerKt.sourceInformationMarkerStart($composer2, 228463923, "CC(remember):NavigationDrawer.android.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer2, 0);
            function3.invoke(drawerPredictiveBackState, $composer2, Integer.valueOf(($dirty2 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    NavigationDrawer_androidKt.DrawerPredictiveBackHandler(drawerState, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }
}
