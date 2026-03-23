package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a0\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020(2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002\u001a\u0093\u0001\u0010+\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020,2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a>\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a \u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0002\u001a;\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00150\f2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020>H\u0007¢\u0006\u0002\u0010?\u001a+\u0010@\u001a\u00020,2\u0006\u0010:\u001a\u00020A2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010B\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C²\u0006\n\u0010D\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = Dp.m6693constructorimpl(56);
    private static final float DrawerPositionalThreshold = Dp.m6693constructorimpl(56);
    private static final float DrawerVelocityThreshold = Dp.m6693constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1435874229, "C(rememberDrawerState)P(1)429@15122L61,429@15058L125:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:428)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart($composer, -524629238, "CC(remember):Drawer.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(function1)) || ($changed & 48) == 32) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(initialValue, function1);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue initialValue, final Function1<? super BottomDrawerValue, Boolean> function1, final AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1477366969, "C(rememberBottomDrawerState)P(2,1)448@15797L7,452@15941L91,449@15816L216:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberBottomDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if ((i & 4) != 0) {
            AnimationSpec animationSpec2 = DrawerDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1477366969, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:447)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        boolean z = true;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, function1, animationSpec);
        ComposerKt.sourceInformationMarkerStart($composer, -1985306787, "CC(remember):Drawer.kt#9igjgp");
        boolean zChanged = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density);
        if (((($changed & 112) ^ 48) <= 32 || !$composer.changed(function1)) && ($changed & 48) != 32) {
            z = false;
        }
        boolean invalid$iv = z | zChanged | $composer.changedInstance(animationSpec);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return new BottomDrawerState(initialValue, density, function1, animationSpec);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomDrawerState;
    }

    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1546ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        DrawerState drawerState2;
        boolean z;
        Shape shape;
        float f;
        int i2;
        long drawerBackgroundColor2;
        int $dirty;
        int $dirty2;
        Modifier modifier3;
        DrawerState drawerState3;
        Shape drawerShape2;
        long drawerContentColor2;
        final long scrimColor2;
        final DrawerState drawerState4;
        final long drawerBackgroundColor3;
        final boolean gesturesEnabled2;
        final Shape drawerShape3;
        final float drawerElevation2;
        final long drawerContentColor3;
        Object value$iv$iv;
        Composer $composer2;
        final Modifier modifier4;
        final DrawerState drawerState5;
        final boolean gesturesEnabled3;
        final long scrimColor3;
        final Shape drawerShape4;
        final long drawerBackgroundColor4;
        final long drawerContentColor4;
        final float drawerElevation3;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(1305806945);
        ComposerKt.sourceInformation($composer3, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)491@17842L39,493@17960L5,495@18069L15,496@18118L38,497@18197L10,500@18265L24,501@18337L3449,501@18294L3492:Drawer.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changedInstance(function3) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                int i4 = $composer3.changed(drawerState2) ? 256 : 128;
                $dirty4 |= i4;
            } else {
                drawerState2 = drawerState;
            }
            $dirty4 |= i4;
        } else {
            drawerState2 = drawerState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty4 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 3072) == 0) {
            z = gesturesEnabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                int i6 = $composer3.changed(shape) ? 16384 : 8192;
                $dirty4 |= i6;
            } else {
                shape = drawerShape;
            }
            $dirty4 |= i6;
        } else {
            shape = drawerShape;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f = drawerElevation;
        } else if ((196608 & $changed) == 0) {
            f = drawerElevation;
            $dirty4 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = drawerElevation;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                i2 = i3;
                drawerBackgroundColor2 = drawerBackgroundColor;
                int i8 = $composer3.changed(drawerBackgroundColor2) ? 1048576 : 524288;
                $dirty4 |= i8;
            } else {
                i2 = i3;
                drawerBackgroundColor2 = drawerBackgroundColor;
            }
            $dirty4 |= i8;
        } else {
            i2 = i3;
            drawerBackgroundColor2 = drawerBackgroundColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i9 = $composer3.changed(drawerContentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i9;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i9;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(scrimColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty5 = $dirty;
        if ((i & 512) != 0) {
            $dirty2 = $dirty5 | 805306368;
        } else {
            if (($changed & 805306368) == 0) {
                $dirty5 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
            }
            $dirty2 = $dirty5;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            drawerState5 = drawerState2;
            drawerElevation3 = f;
            scrimColor3 = scrimColor;
            drawerBackgroundColor4 = drawerBackgroundColor2;
            gesturesEnabled3 = z;
            drawerShape4 = shape;
            drawerContentColor4 = drawerContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    modifier3 = modifier5;
                    drawerState3 = rememberDrawerState(DrawerValue.Closed, null, $composer3, 6, 2);
                    $dirty2 &= -897;
                } else {
                    modifier3 = modifier5;
                    drawerState3 = drawerState2;
                }
                boolean gesturesEnabled4 = i5 != 0 ? true : z;
                if ((i & 16) != 0) {
                    drawerShape2 = DrawerDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty2 &= -57345;
                } else {
                    drawerShape2 = shape;
                }
                float drawerElevation4 = i7 != 0 ? DrawerDefaults.INSTANCE.m1543getElevationD9Ej5fM() : f;
                if ((i & 64) != 0) {
                    drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor($composer3, 6);
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    drawerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                    drawerState4 = drawerState3;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    gesturesEnabled2 = gesturesEnabled4;
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation4;
                    drawerContentColor3 = drawerContentColor2;
                    scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    modifier2 = modifier3;
                } else {
                    scrimColor2 = scrimColor;
                    drawerState4 = drawerState3;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    gesturesEnabled2 = gesturesEnabled4;
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation4;
                    drawerContentColor3 = drawerContentColor2;
                    modifier2 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                drawerContentColor3 = drawerContentColor;
                scrimColor2 = scrimColor;
                drawerBackgroundColor3 = drawerBackgroundColor2;
                drawerState4 = drawerState2;
                gesturesEnabled2 = z;
                drawerShape3 = shape;
                drawerElevation2 = f;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305806945, $dirty2, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:499)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer4, int $changed2) {
                    BoxWithConstraintsScope boxWithConstraintsScope;
                    Object value$iv;
                    Function0 factory$iv$iv$iv;
                    Object value$iv2;
                    Object value$iv3;
                    Object value$iv4;
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer4, "C510@18716L7,511@18743L274,511@18732L285,520@19060L7,521@19099L2681:Drawer.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 6) == 0) {
                        boxWithConstraintsScope = $this$BoxWithConstraints;
                        $dirty6 |= $composer4.changed(boxWithConstraintsScope) ? 4 : 2;
                    } else {
                        boxWithConstraintsScope = $this$BoxWithConstraints;
                    }
                    if (($dirty6 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(816674999, $dirty6, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:502)");
                        }
                        long modalDrawerConstraints = boxWithConstraintsScope.mo587getConstraintsmsEJaDk();
                        if (!Constraints.m6632getHasBoundedWidthimpl(modalDrawerConstraints)) {
                            throw new IllegalStateException("Drawer shouldn't have infinite width");
                        }
                        final float minValue = -Constraints.m6636getMaxWidthimpl(modalDrawerConstraints);
                        final float maxValue = 0.0f;
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer4.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final Density density = (Density) objConsume;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1443044791, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(drawerState4) | $composer4.changed(density) | $composer4.changed(minValue);
                        final DrawerState drawerState6 = drawerState4;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    drawerState6.setDensity$material_release(density);
                                    final float f2 = minValue;
                                    final float f3 = maxValue;
                                    DraggableAnchors anchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.at(DrawerValue.Closed, f2);
                                            draggableAnchorsConfig.at(DrawerValue.Open, f3);
                                        }
                                    });
                                    AnchoredDraggableState.updateAnchors$default(drawerState6.getAnchoredDraggableState$material_release(), anchors, null, 2, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        EffectsKt.SideEffect((Function0) value$iv, $composer4, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer4.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        boolean isRtl = objConsume2 == LayoutDirection.Rtl;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        AnchoredDraggableState<DrawerValue> anchoredDraggableState$material_release = drawerState4.getAnchoredDraggableState$material_release();
                        Modifier modifier$iv = AnchoredDraggableKt.anchoredDraggable(companion, anchoredDraggableState$material_release, Orientation.Horizontal, (56 & 4) != 0 ? true : gesturesEnabled2, (56 & 8) != 0 ? false : isRtl, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release.isAnimationRunning() : false);
                        final DrawerState drawerState7 = drawerState4;
                        final boolean z2 = gesturesEnabled2;
                        final CoroutineScope coroutineScope = scope;
                        long j = scrimColor2;
                        Shape shape2 = drawerShape3;
                        long j2 = drawerBackgroundColor3;
                        long j3 = drawerContentColor3;
                        float f2 = drawerElevation2;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(factory$iv$iv$iv2);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i11 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1741680964, "C530@19417L45,535@19551L292,543@19872L106,533@19475L553,548@20062L33,*550@20162L7,559@20626L222,567@20933L555,584@21683L87,549@20108L1662:Drawer.kt#jmzs0o");
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -974768379, "C531@19439L9:Drawer.kt#jmzs0o");
                        function22.invoke($composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        boolean zIsOpen = drawerState7.isOpen();
                        ComposerKt.sourceInformationMarkerStart($composer4, -56181030, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(z2) | $composer4.changed(drawerState7) | $composer4.changedInstance(coroutineScope);
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (z2 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                    }
                                }

                                /* compiled from: Drawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", f = "Drawer.kt", i = {}, l = {541}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        Function0 function0 = (Function0) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, -56170944, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv3 = $composer4.changed(minValue) | $composer4.changed(drawerState7);
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(DrawerKt.calculateFraction(minValue, maxValue, drawerState7.requireOffset$material_release()));
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        DrawerKt.m1547ScrimBx497Mc(zIsOpen, function0, (Function0) value$iv3, j, $composer4, 0);
                        final String navigationMenu = Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1672getNavigationMenuUdPEhr4(), $composer4, 6);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = $composer4.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density $this$invoke_u24lambda_u247_u24lambda_u244 = (Density) objConsume3;
                        Modifier modifierM729sizeInqDBjuR0 = SizeKt.m729sizeInqDBjuR0(Modifier.INSTANCE, $this$invoke_u24lambda_u247_u24lambda_u244.mo364toDpu2uoSUM(Constraints.m6638getMinWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo364toDpu2uoSUM(Constraints.m6637getMinHeightimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo364toDpu2uoSUM(Constraints.m6636getMaxWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo364toDpu2uoSUM(Constraints.m6635getMaxHeightimpl(modalDrawerConstraints)));
                        ComposerKt.sourceInformationMarkerStart($composer4, -56146700, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv4 = $composer4.changed(drawerState7);
                        Object it$iv4 = $composer4.rememberedValue();
                        if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                    return IntOffset.m6816boximpl(m1553invokeBjo55l4(density2));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1553invokeBjo55l4(Density $this$offset) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState7.requireOffset$material_release()), 0);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierM685paddingqDBjuR0$default = PaddingKt.m685paddingqDBjuR0$default(OffsetKt.offset(modifierM729sizeInqDBjuR0, (Function1) value$iv4), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -56136543, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(navigationMenu) | $composer4.changed(drawerState7) | $composer4.changedInstance(coroutineScope);
                        Object it$iv5 = $composer4.rememberedValue();
                        if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                    SemanticsPropertiesKt.setPaneTitle($this$semantics, navigationMenu);
                                    if (drawerState7.isOpen()) {
                                        final DrawerState drawerState8 = drawerState7;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        SemanticsPropertiesKt.dismiss$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (drawerState8.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00761(drawerState8, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", f = "Drawer.kt", i = {}, l = {576}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C00761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C00761(DrawerState drawerState, Continuation<? super C00761> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C00761(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C00761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            this.label = 1;
                                                            if (this.$drawerState.close(this) != coroutine_suspended) {
                                                                break;
                                                            } else {
                                                                return coroutine_suspended;
                                                            }
                                                        case 1:
                                                            ResultKt.throwOnFailure($result);
                                                            break;
                                                        default:
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        }, 1, null);
                                    }
                                }
                            };
                            $composer4.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        SurfaceKt.m1676SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierM685paddingqDBjuR0$default, false, (Function1) value$iv5, 1, null), shape2, j2, j3, null, f2, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C585@21701L55:Drawer.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941234439, $changed3, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:585)");
                                }
                                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function3 content$iv = function32;
                                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv3 = (6 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    $composer5.createNode(factory$iv$iv$iv4);
                                } else {
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3678constructorimpl($composer5);
                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
                                }
                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer5, Integer.valueOf(((6 >> 6) & 112) | 6));
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, 1572864, 16);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, 3072, 6);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier2;
            drawerState5 = drawerState4;
            gesturesEnabled3 = gesturesEnabled2;
            scrimColor3 = scrimColor2;
            drawerShape4 = drawerShape3;
            drawerBackgroundColor4 = drawerBackgroundColor3;
            drawerContentColor4 = drawerContentColor3;
            drawerElevation3 = drawerElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
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

                public final void invoke(Composer composer, int i10) {
                    DrawerKt.m1546ModalDrawerGs3lGvM(function3, modifier4, drawerState5, gesturesEnabled3, drawerShape4, drawerElevation3, drawerBackgroundColor4, drawerContentColor4, scrimColor3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1544BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomDrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        BottomDrawerState bottomDrawerState;
        boolean z;
        Shape shape;
        float f;
        long j;
        int i2;
        Modifier modifier2;
        int $dirty;
        BottomDrawerState drawerState2;
        Shape drawerShape2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        final long scrimColor2;
        final BottomDrawerState drawerState3;
        final boolean gesturesEnabled2;
        final Shape drawerShape3;
        final float drawerElevation2;
        final long drawerBackgroundColor3;
        final long drawerContentColor3;
        Modifier modifier3;
        int $dirty2;
        Object value$iv$iv;
        Composer $composer2;
        final Modifier modifier4;
        final boolean gesturesEnabled3;
        final BottomDrawerState drawerState4;
        final long scrimColor3;
        final Shape drawerShape4;
        final long drawerBackgroundColor4;
        final long drawerContentColor4;
        final float drawerElevation3;
        Composer $composer3 = $composer.startRestartGroup(625649286);
        ComposerKt.sourceInformation($composer3, "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)624@23676L33,626@23788L5,628@23897L15,629@23946L38,630@24025L10,633@24093L24,634@24165L4601,634@24122L4644:Drawer.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
            function32 = function3;
        } else if (($changed & 6) == 0) {
            function32 = function3;
            $dirty3 |= $composer3.changedInstance(function32) ? 4 : 2;
        } else {
            function32 = function3;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                bottomDrawerState = drawerState;
                int i4 = $composer3.changedInstance(bottomDrawerState) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                bottomDrawerState = drawerState;
            }
            $dirty3 |= i4;
        } else {
            bottomDrawerState = drawerState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 3072) == 0) {
            z = gesturesEnabled;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                int i6 = $composer3.changed(shape) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                shape = drawerShape;
            }
            $dirty3 |= i6;
        } else {
            shape = drawerShape;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f = drawerElevation;
        } else if ((196608 & $changed) == 0) {
            f = drawerElevation;
            $dirty3 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = drawerElevation;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = drawerBackgroundColor;
                int i8 = $composer3.changed(j) ? 1048576 : 524288;
                $dirty3 |= i8;
            } else {
                j = drawerBackgroundColor;
            }
            $dirty3 |= i8;
        } else {
            j = drawerBackgroundColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                i2 = i3;
                int i9 = $composer3.changed(drawerContentColor) ? 8388608 : 4194304;
                $dirty3 |= i9;
            } else {
                i2 = i3;
            }
            $dirty3 |= i9;
        } else {
            i2 = i3;
        }
        if ((100663296 & $changed) == 0) {
            $dirty3 |= ((i & 256) == 0 && $composer3.changed(scrimColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($dirty3 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            $composer2 = $composer3;
            drawerState4 = bottomDrawerState;
            gesturesEnabled3 = z;
            drawerContentColor4 = drawerContentColor;
            drawerBackgroundColor4 = j;
            drawerShape4 = shape;
            drawerElevation3 = f;
            scrimColor3 = scrimColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    int $dirty4 = $dirty3;
                    modifier2 = modifier5;
                    drawerState2 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, null, $composer3, 6, 6);
                    $dirty = $dirty4 & (-897);
                } else {
                    modifier2 = modifier5;
                    $dirty = $dirty3;
                    drawerState2 = bottomDrawerState;
                }
                boolean gesturesEnabled4 = i5 != 0 ? true : z;
                if ((i & 16) != 0) {
                    drawerShape2 = DrawerDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty &= -57345;
                } else {
                    drawerShape2 = shape;
                }
                float drawerElevation4 = i7 != 0 ? DrawerDefaults.INSTANCE.m1543getElevationD9Ej5fM() : f;
                if ((i & 64) != 0) {
                    drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor($composer3, 6);
                    $dirty &= -3670017;
                } else {
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 128) != 0) {
                    drawerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 256) != 0) {
                    drawerState3 = drawerState2;
                    gesturesEnabled2 = gesturesEnabled4;
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation4;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerContentColor3 = drawerContentColor2;
                    scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty3 = $dirty & (-234881025);
                    modifier3 = modifier2;
                } else {
                    scrimColor2 = scrimColor;
                    drawerState3 = drawerState2;
                    gesturesEnabled2 = gesturesEnabled4;
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation4;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerContentColor3 = drawerContentColor2;
                    $dirty3 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    drawerContentColor3 = drawerContentColor;
                    scrimColor2 = scrimColor;
                    $dirty3 &= -234881025;
                    drawerBackgroundColor3 = j;
                    drawerState3 = bottomDrawerState;
                    gesturesEnabled2 = z;
                    drawerShape3 = shape;
                    drawerElevation2 = f;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    drawerContentColor3 = drawerContentColor;
                    scrimColor2 = scrimColor;
                    drawerBackgroundColor3 = j;
                    drawerState3 = bottomDrawerState;
                    gesturesEnabled2 = z;
                    drawerShape3 = shape;
                    drawerElevation2 = f;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625649286, $dirty3, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:632)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                $dirty2 = $dirty3;
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                $dirty2 = $dirty3;
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:56:0x027f  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0282  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x0347  */
                /* JADX WARN: Removed duplicated region for block: B:83:0x03a2  */
                /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r55, androidx.compose.runtime.Composer r56, int r57) {
                    /*
                        Method dump skipped, instructions count: 934
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$BottomDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
                }
            }, $composer3, 54), $composer3, 3072, 6);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            gesturesEnabled3 = gesturesEnabled2;
            drawerState4 = drawerState3;
            scrimColor3 = scrimColor2;
            drawerShape4 = drawerShape3;
            drawerBackgroundColor4 = drawerBackgroundColor3;
            drawerContentColor4 = drawerContentColor3;
            drawerElevation3 = drawerElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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

                public final void invoke(Composer composer, int i10) {
                    DrawerKt.m1544BottomDrawerGs3lGvM(function3, modifier4, drawerState4, gesturesEnabled3, drawerShape4, drawerElevation3, drawerBackgroundColor4, drawerContentColor4, scrimColor3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        float $this$fastCoerceIn$iv = (pos - a) / (b - a);
        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
            return 1.0f;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1545BottomDrawerScrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        DrawerKt$BottomDrawerScrim$dismissModifier$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color):Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513067266, $dirty, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:792)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                $composer2.startReplaceGroup(1552727430);
                ComposerKt.sourceInformation($composer2, "794@30102L121,798@30250L30,816@30803L62,812@30694L171");
                int $dirty2 = $dirty;
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1065353216 : 0, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeDrawer = Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1668getCloseDrawerUdPEhr4(), $composer2, 6);
                if (visible) {
                    $composer2.startReplaceGroup(1552955900);
                    ComposerKt.sourceInformation($composer2, "801@30388L73,804@30514L122");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1612470835, "CC(remember):Drawer.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1612466754, "CC(remember):Drawer.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changed(closeDrawer) | (($dirty2 & 112) == 32);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setContentDescription($this$semantics, closeDrawer);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissModifier = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(1553272286);
                    $composer2.endReplaceGroup();
                    dismissModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, -1612457566, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(alpha$delegate) | (($dirty2 & 14) == 4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$Canvas) {
                            DrawScope.CC.m4747drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$2(alpha$delegate), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1553488542);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DrawerKt.m1545BottomDrawerScrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1547ScrimBx497Mc(final boolean open, final Function0<Unit> function0, final Function0<Float> function02, final long color, Composer $composer, final int $changed) {
        Modifier.Companion dismissDrawer;
        Object value$iv;
        DrawerKt$Scrim$dismissDrawer$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)829@31020L30,845@31464L51,841@31373L142:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(open) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(color) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, $dirty, -1, "androidx.compose.material.Scrim (Drawer.kt:828)");
            }
            final String closeDrawer = Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1668getCloseDrawerUdPEhr4(), $composer2, 6);
            if (open) {
                $composer2.startReplaceGroup(487703622);
                ComposerKt.sourceInformation($composer2, "832@31139L35,833@31223L108");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1262659875, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv = ($dirty & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1262662636, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(closeDrawer) | (($dirty & 112) == 32);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContentDescription($this$semantics, closeDrawer);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                dismissDrawer = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(487952490);
                $composer2.endReplaceGroup();
                dismissDrawer = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissDrawer);
            ComposerKt.sourceInformationMarkerStart($composer2, 1262670291, "CC(remember):Drawer.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        DrawScope.CC.m4747drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DrawerKt.m1547ScrimBx497Mc(open, function0, function02, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* compiled from: Drawer.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\rH\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\r*\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation = Orientation.Vertical;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState) {
            this.$state = anchoredDraggableState;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo479onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo477onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m5286equalsimpl0(source, NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo478onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                r0.<init>(r6, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                switch(r2) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2c:
                long r7 = r0.J$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L61
            L32:
                kotlin.ResultKt.throwOnFailure(r9)
                r2 = r6
                float r3 = r2.velocityToFloat(r7)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r4 = r4.requireOffset()
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 >= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
                androidx.compose.material.DraggableAnchors r5 = r5.getAnchors()
                float r5 = r5.minAnchor()
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 <= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                r0.J$0 = r7
                r5 = 1
                r0.label = r5
                java.lang.Object r2 = r4.settle(r3, r0)
                if (r2 != r1) goto L61
                return r1
            L61:
                goto L68
            L62:
                androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r7 = r7.m6945getZero9UxMQ8M()
            L68:
                androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.AnonymousClass1.mo478onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo476onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r4 = this;
                boolean r5 = r9 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                r5.<init>(r4, r9)
            L19:
                java.lang.Object r6 = r5.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                switch(r0) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2c:
                long r7 = r5.J$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                r0 = r4
                androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
                float r2 = r0.velocityToFloat(r7)
                r5.J$0 = r7
                r3 = 1
                r5.label = r3
                java.lang.Object r0 = r1.settle(r2, r5)
                if (r0 != r9) goto L48
                return r9
            L48:
                androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6925boximpl(r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.AnonymousClass1.mo476onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return androidx.compose.ui.geometry.OffsetKt.Offset(this.orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.orientation == Orientation.Horizontal ? Velocity.m6934getXimpl($this$toFloat) : Velocity.m6935getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.orientation == Orientation.Horizontal ? Offset.m3945getXimpl($this$toFloat) : Offset.m3946getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new AnonymousClass1(anchoredDraggableState);
    }
}
