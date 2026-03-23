package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ar\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0002\u0010\u001b\u001a\u00020\u00062\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u009b\u0001\u0010+\u001a\u00020\u00062\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0 2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001c\u00103\u001a\u0002042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u000207H\u0002\u001a!\u00108\u001a\u00020\u001e2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\"H\u0007¢\u0006\u0002\u0010;\u001a;\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020/0@2\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010B\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m6693constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m6693constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m6693constructorimpl(125);

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1808153344, "C(rememberBottomSheetState)P(2)236@8776L7,244@9018L210,237@8795L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:235)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        boolean z = true;
        Object[] objArr = {animationSpec};
        Saver<BottomSheetState, ?> Saver = BottomSheetState.INSTANCE.Saver(animationSpec, function1, density);
        ComposerKt.sourceInformationMarkerStart($composer, -1916212862, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean zChanged = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density) | $composer.changedInstance(animationSpec);
        if (((($changed & 896) ^ 384) <= 256 || !$composer.changed(function1)) && ($changed & 384) != 256) {
            z = false;
        }
        boolean invalid$iv = z | zChanged;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomSheetState invoke() {
                    return new BottomSheetState(initialValue, density, animationSpec, function1);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -1022285988, "C(rememberBottomSheetScaffoldState)274@9912L35,275@9992L32,277@10066L196:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            $composer2 = $composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer2, 6, 6);
        } else {
            $composer2 = $composer;
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, 200088250, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Composer $this$cache$iv = $composer2;
            Object it$iv = $this$cache$iv.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $this$cache$iv.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:276)");
        }
        ComposerKt.sourceInformationMarkerStart($composer2, 200090782, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer2.changed(bottomSheetState)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer2.changed(snackbarHostState)) || ($changed & 48) == 32);
        Composer $this$cache$iv2 = $composer2;
        Object it$iv2 = $this$cache$iv2.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $this$cache$iv2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return bottomSheetScaffoldState;
    }

    /* renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    public static final void m1455BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        BottomSheetScaffoldState scaffoldState2;
        Function2 topBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        boolean sheetGesturesEnabled2;
        int $dirty1;
        int $dirty12;
        long j;
        CornerBasedShape sheetShape2;
        float sheetElevation2;
        Function2 floatingActionButton2;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        int $dirty13;
        float sheetPeekHeight2;
        int $dirty;
        long backgroundColor2;
        int $dirty2;
        long contentColor2;
        long backgroundColor3;
        Shape sheetShape3;
        long sheetBackgroundColor3;
        int $dirty14;
        float sheetPeekHeight3;
        final Shape sheetShape4;
        final float sheetPeekHeight4;
        final long contentColor3;
        Composer $composer2;
        final float sheetPeekHeight5;
        final Function3 snackbarHost2;
        final boolean sheetGesturesEnabled3;
        final Function2 topBar2;
        final Function2 floatingActionButton3;
        final int floatingActionButtonPosition3;
        final Modifier modifier3;
        final BottomSheetScaffoldState scaffoldState3;
        final float sheetElevation3;
        final long sheetBackgroundColor4;
        final long sheetContentColor3;
        final Shape sheetShape5;
        final long sheetBackgroundColor5;
        int $dirty15;
        Composer $composer3 = $composer.startRestartGroup(-423121424);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetScaffold)P(8,5,6,15,14,3,4:c#material.FabPosition,11,13,10:c#ui.unit.Dp,7:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp,0:c#ui.graphics.Color,2:c#ui.graphics.Color)333@13308L34,339@13677L6,341@13808L6,342@13855L37,344@14008L6,345@14053L32,353@14273L1864,348@14144L1993:BottomSheetScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scaffoldState2 = scaffoldState;
                int i3 = $composer3.changed(scaffoldState2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty3 |= i3;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i4 = i & 8;
        int i5 = 2048;
        if (i4 != 0) {
            $dirty3 |= 3072;
            topBar = function2;
        } else if (($changed & 3072) == 0) {
            topBar = function2;
            $dirty3 |= $composer3.changedInstance(topBar) ? 2048 : 1024;
        } else {
            topBar = function2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
            snackbarHost = function32;
        } else if (($changed & 24576) == 0) {
            snackbarHost = function32;
            $dirty3 |= $composer3.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            snackbarHost = function32;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            floatingActionButton = function22;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            floatingActionButton = function22;
            $dirty3 |= $composer3.changedInstance(floatingActionButton) ? 131072 : 65536;
        } else {
            floatingActionButton = function22;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 1572864) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty3 |= $composer3.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
            sheetGesturesEnabled2 = sheetGesturesEnabled;
        } else if (($changed & 12582912) == 0) {
            sheetGesturesEnabled2 = sheetGesturesEnabled;
            $dirty3 |= $composer3.changed(sheetGesturesEnabled2) ? 8388608 : 4194304;
        } else {
            sheetGesturesEnabled2 = sheetGesturesEnabled;
        }
        if (($changed & 100663296) == 0) {
            $dirty3 |= ((i & 256) == 0 && $composer3.changed(sheetShape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty3 |= ((i & 512) == 0 && $composer3.changed(sheetElevation)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            if ((i & 1024) == 0) {
                $dirty15 = $changed1;
                int i10 = $composer3.changed(sheetBackgroundColor) ? 4 : 2;
                $dirty1 = $dirty15 | i10;
            } else {
                $dirty15 = $changed1;
            }
            $dirty1 = $dirty15 | i10;
        } else {
            $dirty1 = $changed1;
        }
        if (($changed1 & 48) == 0) {
            int $dirty16 = $dirty1;
            int $dirty17 = i & 2048;
            $dirty1 = $dirty16 | (($dirty17 == 0 && $composer3.changed(sheetContentColor)) ? 32 : 16);
        }
        int $dirty18 = $dirty1;
        int $dirty19 = $changed1 & 384;
        if ($dirty19 == 0) {
            $dirty12 = $dirty18 | (((i & 4096) == 0 && $composer3.changed(sheetPeekHeight)) ? 256 : 128);
        } else {
            $dirty12 = $dirty18;
        }
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0) {
                j = backgroundColor;
                if (!$composer3.changed(j)) {
                }
                $dirty12 |= i5;
            } else {
                j = backgroundColor;
            }
            i5 = 1024;
            $dirty12 |= i5;
        } else {
            j = backgroundColor;
        }
        if (($changed1 & 24576) == 0) {
            $dirty12 |= ((i & 16384) == 0 && $composer3.changed(contentColor)) ? 16384 : 8192;
        }
        if ((i & 32768) != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty12 |= $composer3.changedInstance(function33) ? 131072 : 65536;
        }
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 74899) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            sheetShape5 = sheetShape;
            contentColor3 = contentColor;
            $composer2 = $composer3;
            sheetBackgroundColor5 = j;
            topBar2 = topBar;
            snackbarHost2 = snackbarHost;
            floatingActionButton3 = floatingActionButton;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            sheetGesturesEnabled3 = sheetGesturesEnabled2;
            sheetElevation3 = sheetElevation;
            sheetBackgroundColor4 = sheetBackgroundColor;
            sheetContentColor3 = sheetContentColor;
            sheetPeekHeight5 = sheetPeekHeight;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, $composer3, 0, 3);
                }
                Function2 topBar3 = i4 != 0 ? null : topBar;
                if (i6 != 0) {
                    snackbarHost = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1521getLambda1$material_release();
                }
                if (i7 != 0) {
                    floatingActionButton = null;
                }
                if (i8 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1574getEnd5ygKITE();
                }
                if (i9 != 0) {
                    sheetGesturesEnabled2 = true;
                }
                if ((i & 256) != 0) {
                    sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty3 &= -234881025;
                } else {
                    sheetShape2 = sheetShape;
                }
                if ((i & 512) != 0) {
                    sheetElevation2 = BottomSheetScaffoldDefaults.INSTANCE.m1452getSheetElevationD9Ej5fM();
                    $dirty3 &= -1879048193;
                } else {
                    sheetElevation2 = sheetElevation;
                }
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                    floatingActionButton2 = floatingActionButton;
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                } else {
                    floatingActionButton2 = floatingActionButton;
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                if ((i & 2048) != 0) {
                    sheetContentColor2 = ColorsKt.m1512contentColorForek8zF_U(sheetBackgroundColor2, $composer3, $dirty12 & 14);
                    $dirty13 = $dirty12 & (-113);
                } else {
                    sheetContentColor2 = sheetContentColor;
                    $dirty13 = $dirty12;
                }
                Function2 topBar4 = topBar3;
                if ((i & 4096) != 0) {
                    sheetPeekHeight2 = BottomSheetScaffoldDefaults.INSTANCE.m1453getSheetPeekHeightD9Ej5fM();
                    $dirty13 &= -897;
                } else {
                    sheetPeekHeight2 = sheetPeekHeight;
                }
                float sheetPeekHeight6 = sheetPeekHeight2;
                if ((i & 8192) != 0) {
                    $dirty = $dirty3;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1487getBackground0d7_KjU();
                    $dirty13 &= -7169;
                } else {
                    $dirty = $dirty3;
                    backgroundColor2 = j;
                }
                if ((i & 16384) != 0) {
                    long contentColor4 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty13 >> 9) & 14);
                    int i11 = (-57345) & $dirty13;
                    sheetPeekHeight3 = sheetPeekHeight6;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor4;
                    backgroundColor3 = backgroundColor2;
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    floatingActionButton = floatingActionButton2;
                    $dirty14 = i11;
                    sheetShape3 = sheetShape2;
                    topBar = topBar4;
                } else {
                    $dirty2 = $dirty;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    sheetShape3 = sheetShape2;
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    floatingActionButton = floatingActionButton2;
                    topBar = topBar4;
                    $dirty14 = $dirty13;
                    sheetPeekHeight3 = sheetPeekHeight6;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty3 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty12 &= -113;
                }
                int $dirty110 = $dirty12;
                if ((i & 4096) != 0) {
                    $dirty110 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty110 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty110 &= -57345;
                }
                sheetElevation2 = sheetElevation;
                sheetContentColor2 = sheetContentColor;
                sheetPeekHeight3 = sheetPeekHeight;
                contentColor2 = contentColor;
                $dirty14 = $dirty110;
                backgroundColor3 = j;
                sheetShape3 = sheetShape;
                $dirty2 = $dirty3;
                sheetBackgroundColor3 = sheetBackgroundColor;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                sheetShape4 = sheetShape3;
                sheetPeekHeight4 = sheetPeekHeight3;
                ComposerKt.traceEventStart(-423121424, $dirty2, $dirty14, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:347)");
            } else {
                sheetShape4 = sheetShape3;
                sheetPeekHeight4 = sheetPeekHeight3;
            }
            final long sheetBackgroundColor6 = sheetBackgroundColor3;
            final Function2 topBar5 = topBar;
            final Function3 snackbarHost3 = snackbarHost;
            final Function2 floatingActionButton4 = floatingActionButton;
            final int floatingActionButtonPosition4 = floatingActionButtonPosition2;
            final BottomSheetScaffoldState scaffoldState4 = scaffoldState2;
            final float sheetElevation4 = sheetElevation2;
            final boolean sheetGesturesEnabled4 = sheetGesturesEnabled2;
            final long sheetContentColor4 = sheetContentColor2;
            float sheetPeekHeight7 = sheetPeekHeight4;
            Shape sheetShape6 = sheetShape4;
            long backgroundColor4 = backgroundColor3;
            long contentColor5 = contentColor2;
            SurfaceKt.m1676SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, backgroundColor4, contentColor5, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function2<Composer, Integer, Unit> function23;
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C356@14358L52,357@14438L1265,384@15789L77,389@15998L50,354@14283L1848:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-131096268, $changed2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:354)");
                        }
                        BottomSheetState bottomSheetState = scaffoldState4.getBottomSheetState();
                        Function2<Composer, Integer, Unit> function24 = topBar5;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        final float f = sheetPeekHeight4;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1143451324, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.1
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
                                ComposerKt.sourceInformation($composer5, "C356@14360L48:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1143451324, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:356)");
                                }
                                function34.invoke(PaddingKt.m678PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, null), $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        final boolean z = sheetGesturesEnabled4;
                        final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState4;
                        final float f2 = sheetPeekHeight4;
                        final Shape shape = sheetShape4;
                        final float f3 = sheetElevation4;
                        final long j2 = sheetBackgroundColor6;
                        final long j3 = sheetContentColor4;
                        final Function3<ColumnScope, Composer, Integer, Unit> function35 = function3;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1856649243, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.2
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
                                Modifier.Companion nestedScroll;
                                Object value$iv2;
                                ComposerKt.sourceInformation($composer5, "C369@15064L625:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1856649243, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:358)");
                                }
                                if (z) {
                                    $composer5.startReplaceGroup(981667628);
                                    ComposerKt.sourceInformation($composer5, "361@14599L390");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material_release();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 447311688, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                    boolean invalid$iv = $composer5.changed(anchoredDraggableState$material_release);
                                    BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                                    Object it$iv = $composer5.rememberedValue();
                                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState2.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                        $composer5.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    nestedScroll = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) value$iv2, null, 2, null);
                                    $composer5.endReplaceGroup();
                                } else {
                                    $composer5.startReplaceGroup(447325386);
                                    $composer5.endReplaceGroup();
                                    nestedScroll = Modifier.INSTANCE;
                                }
                                BottomSheetScaffoldKt.m1454BottomSheetdAqlCkY(bottomSheetScaffoldState.getBottomSheetState(), z, shape, f3, j2, j3, f2, SizeKt.m717requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(nestedScroll, 0.0f, 1, null), f2, 0.0f, 2, null), function35, $composer5, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        Function2<Composer, Integer, Unit> function25 = floatingActionButton4;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = snackbarHost3;
                        final BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState4;
                        ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.3
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
                                ComposerKt.sourceInformation($composer5, "C385@15807L45:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1011922215, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:385)");
                                }
                                function36.invoke(bottomSheetScaffoldState2.getSnackbarHostState(), $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        float f4 = sheetPeekHeight4;
                        ComposerKt.sourceInformationMarkerStart($composer4, 854054741, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(scaffoldState4);
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = scaffoldState4;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            function23 = function24;
                            value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$4$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(bottomSheetScaffoldState3.getBottomSheetState().requireOffset());
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            function23 = function24;
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        BottomSheetScaffoldKt.m1456BottomSheetScaffoldLayoutHJHHjMs(function23, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, function25, composableLambdaRememberComposableLambda3, f4, (Function0) value$iv, floatingActionButtonPosition4, bottomSheetState, $composer4, 25008);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, (($dirty14 >> 3) & 896) | 1572864 | (($dirty14 >> 3) & 7168), 50);
            contentColor3 = contentColor5;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            boolean z = sheetGesturesEnabled2;
            sheetPeekHeight5 = sheetPeekHeight7;
            snackbarHost2 = snackbarHost;
            sheetGesturesEnabled3 = z;
            topBar2 = topBar;
            floatingActionButton3 = floatingActionButton;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            sheetElevation3 = sheetElevation2;
            sheetBackgroundColor4 = sheetBackgroundColor6;
            sheetContentColor3 = sheetContentColor4;
            sheetShape5 = sheetShape6;
            sheetBackgroundColor5 = backgroundColor4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                public final void invoke(Composer composer, int i12) {
                    BottomSheetScaffoldKt.m1455BottomSheetScaffoldHnlDQGw(function3, modifier3, scaffoldState3, topBar2, snackbarHost2, floatingActionButton3, floatingActionButtonPosition3, sheetGesturesEnabled3, sheetShape5, sheetElevation3, sheetBackgroundColor4, sheetContentColor3, sheetPeekHeight5, sheetBackgroundColor5, contentColor3, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheet-dAqlCkY, reason: not valid java name */
    public static final void m1454BottomSheetdAqlCkY(final BottomSheetState state, final boolean sheetGesturesEnabled, final Shape sheetShape, final float sheetElevation, final long sheetBackgroundColor, final long sheetContentColor, final float sheetPeekHeight, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        int i2;
        Object value$iv$iv;
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-412323066);
        ComposerKt.sourceInformation($composer3, "C(BottomSheet)P(8,5,7,4:c#ui.unit.Dp,2:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.unit.Dp,1)408@16519L24,*409@16585L7,415@16779L792,436@17795L893,461@18852L29,410@16625L2262:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(sheetGesturesEnabled) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(sheetShape) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(sheetElevation) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(sheetBackgroundColor) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer3.changed(sheetContentColor) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(sheetPeekHeight) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
            modifier2 = modifier;
            i2 = 1572864;
        } else if (($changed & 12582912) == 0) {
            modifier2 = modifier;
            i2 = 1572864;
            $dirty |= $composer3.changed(modifier2) ? 8388608 : 4194304;
        } else {
            modifier2 = modifier;
            i2 = 1572864;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412323066, $dirty2, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:407)");
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
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BottomSheet_dAqlCkY_u24lambda_u243 = (Density) objConsume;
            final float peekHeightPx = $this$BottomSheet_dAqlCkY_u24lambda_u243.mo367toPx0680j_4(sheetPeekHeight);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = state.getAnchoredDraggableState$material_release();
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart($composer3, -1416603834, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(peekHeightPx) | (($dirty2 & 14) == 4);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<BottomSheetValue>, ? extends BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BottomSheetValue.values().length];
                            try {
                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<BottomSheetValue>, ? extends BottomSheetValue> invoke(IntSize intSize, Constraints constraints) {
                        return m1459invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                    }

                    /* renamed from: invoke-GpV2Q24, reason: not valid java name */
                    public final Pair<DraggableAnchors<BottomSheetValue>, BottomSheetValue> m1459invokeGpV2Q24(long sheetSize, long constraints) {
                        BottomSheetValue newTarget;
                        final int layoutHeight = Constraints.m6635getMaxHeightimpl(constraints);
                        final float sheetHeight = IntSize.m6866getHeightimpl(sheetSize);
                        final float f = peekHeightPx;
                        DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1$newAnchors$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                invoke2(draggableAnchorsConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                draggableAnchorsConfig.at(BottomSheetValue.Collapsed, layoutHeight - f);
                                if (sheetHeight > 0.0f) {
                                    if (!(sheetHeight == f)) {
                                        draggableAnchorsConfig.at(BottomSheetValue.Expanded, layoutHeight - sheetHeight);
                                    }
                                }
                            }
                        });
                        switch (WhenMappings.$EnumSwitchMapping$0[state.getAnchoredDraggableState$material_release().getTargetValue().ordinal()]) {
                            case 1:
                                newTarget = BottomSheetValue.Collapsed;
                                break;
                            case 2:
                                if (!newAnchors.hasAnchorFor(BottomSheetValue.Expanded)) {
                                    newTarget = BottomSheetValue.Collapsed;
                                    break;
                                } else {
                                    newTarget = BottomSheetValue.Expanded;
                                    break;
                                }
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        return TuplesKt.to(newAnchors, newTarget);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(modifier3, anchoredDraggableState$material_release, orientation, (Function2) value$iv2);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release2 = state.getAnchoredDraggableState$material_release();
            Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(modifierDraggableAnchors, anchoredDraggableState$material_release2, Orientation.Vertical, (56 & 4) != 0 ? true : sheetGesturesEnabled, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release2.isAnimationRunning() : false);
            ComposerKt.sourceInformationMarkerStart($composer3, -1416571221, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | $composer3.changedInstance(scope);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1
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
                        if (state.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                            if (state.isCollapsed()) {
                                final BottomSheetState bottomSheetState = state;
                                final CoroutineScope coroutineScope = scope;
                                SemanticsPropertiesKt.expand$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* compiled from: BottomSheetScaffold.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C00701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomSheetState $state;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00701(BottomSheetState bottomSheetState, Continuation<? super C00701> continuation) {
                                            super(2, continuation);
                                            this.$state = bottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00701(this.$state, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    this.label = 1;
                                                    if (this.$state.expand(this) != coroutine_suspended) {
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

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (bottomSheetState.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00701(bottomSheetState, null), 3, null);
                                        }
                                        return true;
                                    }
                                }, 1, null);
                            } else {
                                final BottomSheetState bottomSheetState2 = state;
                                final CoroutineScope coroutineScope2 = scope;
                                SemanticsPropertiesKt.collapse$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* compiled from: BottomSheetScaffold.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$2$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomSheetState $state;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$state = bottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$state, continuation);
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
                                                    if (this.$state.collapse(this) != coroutine_suspended) {
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

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (bottomSheetState2.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomSheetState2, null), 3, null);
                                        }
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SurfaceKt.m1676SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable, false, (Function1) value$iv, 1, null), sheetShape, sheetBackgroundColor, sheetContentColor, null, sheetElevation, ComposableLambdaKt.rememberComposableLambda(2055704138, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x013d  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r24, int r25) {
                    /*
                        Method dump skipped, instructions count: 321
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }, $composer3, 54), $composer3, (($dirty2 >> 3) & 112) | i2 | (($dirty2 >> 6) & 896) | (($dirty2 >> 6) & 7168) | (458752 & ($dirty2 << 6)), 16);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$4
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

                public final void invoke(Composer composer, int i4) {
                    BottomSheetScaffoldKt.m1454BottomSheetdAqlCkY(state, sheetGesturesEnabled, sheetShape, sheetElevation, sheetBackgroundColor, sheetContentColor, sheetPeekHeight, modifier2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a8  */
    /* renamed from: BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1456BottomSheetScaffoldLayoutHJHHjMs(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, final float r35, final kotlin.jvm.functions.Function0<java.lang.Float> r36, final int r37, final androidx.compose.material.BottomSheetState r38, androidx.compose.runtime.Composer r39, final int r40) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1456BottomSheetScaffoldLayoutHJHHjMs(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, float, kotlin.jvm.functions.Function0, int, androidx.compose.material.BottomSheetState, androidx.compose.runtime.Composer, int):void");
    }

    /* compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
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
                boolean r0 = r9 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.AnonymousClass1.mo478onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
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
                boolean r5 = r9 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.AnonymousClass1.mo476onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m6934getXimpl($this$toFloat) : Velocity.m6935getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m3945getXimpl($this$toFloat) : Offset.m3946getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }
}
