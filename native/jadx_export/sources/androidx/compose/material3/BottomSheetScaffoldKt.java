package androidx.compose.material3;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u008e\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u008d\u0001\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020(2\b\b\u0002\u00106\u001a\u00020\u001bH\u0007¢\u0006\u0002\u00107\u001a7\u00108\u001a\u00020(2\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010<\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010=\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-2E65NiM", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    /* JADX WARN: Removed duplicated region for block: B:287:0x04cf  */
    /* renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1813BottomSheetScaffoldsdMYb0k(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.material3.BottomSheetScaffoldState r40, float r41, float r42, androidx.compose.ui.graphics.Shape r43, long r44, long r46, float r48, float r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, boolean r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, long r54, long r56, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, final int r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1813BottomSheetScaffoldsdMYb0k(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -1474606134, "C(rememberBottomSheetScaffoldState)178@8695L34,179@8774L32,181@8848L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            $composer2 = $composer;
            bottomSheetState = rememberStandardBottomSheetState(null, null, false, $composer2, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer2, -787714761, "CC(remember):BottomSheetScaffold.kt#9igjgp");
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
            ComposerKt.traceEventStart(-1474606134, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:180)");
        }
        ComposerKt.sourceInformationMarkerStart($composer2, -787712229, "CC(remember):BottomSheetScaffold.kt#9igjgp");
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

    public static final SheetState rememberStandardBottomSheetState(SheetValue initialValue, Function1<? super SheetValue, Boolean> function1, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        SheetValue initialValue2;
        Function1 confirmValueChange;
        ComposerKt.sourceInformationMarkerStart($composer, 678511581, "C(rememberStandardBottomSheetState)P(1)204@9680L154:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            SheetValue initialValue3 = SheetValue.PartiallyExpanded;
            initialValue2 = initialValue3;
        } else {
            initialValue2 = initialValue;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange2 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    return true;
                }
            };
            confirmValueChange = confirmValueChange2;
        } else {
            confirmValueChange = function1;
        }
        boolean skipHiddenState2 = (i & 4) != 0 ? true : skipHiddenState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(false, confirmValueChange, initialValue2, skipHiddenState2, $composer, ($changed & 112) | (($changed << 6) & 896) | (($changed << 3) & 7168), 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02f2  */
    /* renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1815StandardBottomSheetw7I5h1o(final androidx.compose.material3.SheetState r27, final float r28, final float r29, final boolean r30, final androidx.compose.ui.graphics.Shape r31, final long r32, final long r34, final float r36, final float r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1815StandardBottomSheetw7I5h1o(androidx.compose.material3.SheetState, float, float, boolean, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-2E65NiM, reason: not valid java name */
    public static final void m1814BottomSheetScaffoldLayout2E65NiM(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function0<Float> function0, final SheetState sheetState, final long containerColor, final long contentColor, Composer $composer, final int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function25;
        long j;
        MultiContentMeasurePolicy value$iv;
        Object value$iv$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1651214892);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(4,8!2,7,5,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color)359@16300L255,370@16635L1950,355@16183L2402:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            function25 = function22;
            $dirty |= $composer2.changedInstance(function25) ? 256 : 128;
        } else {
            function25 = function22;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetState) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changed(containerColor) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            j = contentColor;
            $dirty |= $composer2.changed(j) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            j = contentColor;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651214892, $dirty, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:354)");
            }
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1978getLambda3$material3_release() : function2;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
            final long j2 = j;
            function2Arr[1] = ComposableLambdaKt.rememberComposableLambda(398963586, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C360@16322L215:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(398963586, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous> (BottomSheetScaffold.kt:360)");
                        }
                        SurfaceKt.m2561SurfaceT9BRK9s(modifier, null, containerColor, j2, 0.0f, 0.0f, null, function26, $composer3, 0, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            function2Arr[2] = function23;
            function2Arr[3] = function24;
            List contents$iv = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart($composer2, 1221133327, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = ((3670016 & $dirty) == 1048576) | ((458752 & $dirty) == 131072);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo629measure3p2s80s(MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                        Integer numValueOf;
                        List topBarMeasurables = list.get(0);
                        List bodyMeasurables = list.get(1);
                        List bottomSheetMeasurables = list.get(2);
                        List snackbarHostMeasurables = list.get(3);
                        final int layoutWidth = Constraints.m6636getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6635getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
                        List target$iv = new ArrayList(bottomSheetMeasurables.size());
                        int index$iv$iv = 0;
                        int size = bottomSheetMeasurables.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = bottomSheetMeasurables.get(index$iv$iv);
                            int i = size;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            snackbarHostMeasurables = snackbarHostMeasurables;
                            size = i;
                        }
                        List snackbarHostMeasurables2 = snackbarHostMeasurables;
                        List sheetPlaceables = target$iv;
                        List $this$fastMap$iv = topBarMeasurables;
                        List target$iv2 = new ArrayList($this$fastMap$iv.size());
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastMap$iv.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                            List $this$fastMap$iv2 = $this$fastMap$iv;
                            Measurable it2 = (Measurable) item$iv$iv2;
                            target$iv2.add(it2.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv2++;
                            sheetPlaceables = sheetPlaceables;
                            $this$fastMap$iv = $this$fastMap$iv2;
                        }
                        final List sheetPlaceables2 = sheetPlaceables;
                        final List topBarPlaceables = target$iv2;
                        if (topBarPlaceables.isEmpty()) {
                            numValueOf = null;
                        } else {
                            Placeable it3 = (Placeable) topBarPlaceables.get(0);
                            numValueOf = Integer.valueOf(it3.getHeight());
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Placeable it4 = (Placeable) topBarPlaceables.get(i$iv);
                                    Integer numValueOf2 = Integer.valueOf(it4.getHeight());
                                    if (numValueOf2.compareTo(numValueOf) > 0) {
                                        numValueOf = numValueOf2;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        }
                        Integer num = numValueOf;
                        final int topBarHeight = num != null ? num.intValue() : 0;
                        long bodyConstraints = Constraints.m6626copyZbe2FdA(looseConstraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(looseConstraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(looseConstraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(looseConstraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(looseConstraints) : layoutHeight - topBarHeight);
                        List target$iv3 = new ArrayList(bodyMeasurables.size());
                        int index$iv$iv3 = 0;
                        for (int size3 = bodyMeasurables.size(); index$iv$iv3 < size3; size3 = size3) {
                            Object item$iv$iv3 = bodyMeasurables.get(index$iv$iv3);
                            int index$iv$iv4 = index$iv$iv3;
                            Measurable it5 = (Measurable) item$iv$iv3;
                            target$iv3.add(it5.mo5535measureBRTryo0(bodyConstraints));
                            index$iv$iv3 = index$iv$iv4 + 1;
                        }
                        final List bodyPlaceables = target$iv3;
                        List target$iv4 = new ArrayList(snackbarHostMeasurables2.size());
                        int index$iv$iv5 = 0;
                        for (int size4 = snackbarHostMeasurables2.size(); index$iv$iv5 < size4; size4 = size4) {
                            Object item$iv$iv4 = snackbarHostMeasurables2.get(index$iv$iv5);
                            int index$iv$iv6 = index$iv$iv5;
                            Measurable it6 = (Measurable) item$iv$iv4;
                            target$iv4.add(it6.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv5 = index$iv$iv6 + 1;
                        }
                        final List snackbarPlaceables = target$iv4;
                        final SheetState sheetState2 = sheetState;
                        final Function0<Float> function02 = function0;
                        return MeasureScope.CC.layout$default($this$Layout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError e3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Integer numValueOf3;
                                Integer numValueOf4;
                                int iRoundToInt;
                                List $this$fastMaxOfOrNull$iv = sheetPlaceables2;
                                Integer numValueOf5 = null;
                                if ($this$fastMaxOfOrNull$iv.isEmpty()) {
                                    numValueOf3 = null;
                                } else {
                                    Placeable it7 = $this$fastMaxOfOrNull$iv.get(0);
                                    numValueOf3 = Integer.valueOf(it7.getWidth());
                                    int i$iv2 = 1;
                                    int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv);
                                    if (1 <= lastIndex2) {
                                        while (true) {
                                            Placeable it8 = $this$fastMaxOfOrNull$iv.get(i$iv2);
                                            Integer numValueOf6 = Integer.valueOf(it8.getWidth());
                                            if (numValueOf6.compareTo(numValueOf3) > 0) {
                                                numValueOf3 = numValueOf6;
                                            }
                                            if (i$iv2 == lastIndex2) {
                                                break;
                                            } else {
                                                i$iv2++;
                                            }
                                        }
                                    }
                                }
                                Integer num2 = numValueOf3;
                                int sheetWidth = num2 != null ? num2.intValue() : 0;
                                int sheetOffsetX = Math.max(0, (layoutWidth - sheetWidth) / 2);
                                List $this$fastMaxOfOrNull$iv2 = snackbarPlaceables;
                                if ($this$fastMaxOfOrNull$iv2.isEmpty()) {
                                    numValueOf4 = null;
                                } else {
                                    Placeable it9 = $this$fastMaxOfOrNull$iv2.get(0);
                                    numValueOf4 = Integer.valueOf(it9.getWidth());
                                    int i$iv3 = 1;
                                    int lastIndex3 = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv2);
                                    if (1 <= lastIndex3) {
                                        while (true) {
                                            Placeable it10 = $this$fastMaxOfOrNull$iv2.get(i$iv3);
                                            Integer numValueOf7 = Integer.valueOf(it10.getWidth());
                                            if (numValueOf7.compareTo(numValueOf4) > 0) {
                                                numValueOf4 = numValueOf7;
                                            }
                                            if (i$iv3 == lastIndex3) {
                                                break;
                                            } else {
                                                i$iv3++;
                                            }
                                        }
                                    }
                                }
                                Integer num3 = numValueOf4;
                                int snackbarWidth = num3 != null ? num3.intValue() : 0;
                                List $this$fastMaxOfOrNull$iv3 = snackbarPlaceables;
                                if (!$this$fastMaxOfOrNull$iv3.isEmpty()) {
                                    Placeable it11 = $this$fastMaxOfOrNull$iv3.get(0);
                                    numValueOf5 = Integer.valueOf(it11.getHeight());
                                    int i$iv4 = 1;
                                    int lastIndex4 = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv3);
                                    if (1 <= lastIndex4) {
                                        while (true) {
                                            Placeable it12 = $this$fastMaxOfOrNull$iv3.get(i$iv4);
                                            Integer numValueOf8 = Integer.valueOf(it12.getHeight());
                                            if (numValueOf8.compareTo(numValueOf5) > 0) {
                                                numValueOf5 = numValueOf8;
                                            }
                                            if (i$iv4 == lastIndex4) {
                                                break;
                                            } else {
                                                i$iv4++;
                                            }
                                        }
                                    }
                                }
                                Integer num4 = numValueOf5;
                                int snackbarHeight = num4 != null ? num4.intValue() : 0;
                                int snackbarOffsetX = (layoutWidth - snackbarWidth) / 2;
                                switch (WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()]) {
                                    case 1:
                                        iRoundToInt = MathKt.roundToInt(function02.invoke().floatValue()) - snackbarHeight;
                                        break;
                                    case 2:
                                    case 3:
                                        iRoundToInt = layoutHeight - snackbarHeight;
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                int index$iv = iRoundToInt;
                                List $this$fastForEach$iv = bodyPlaceables;
                                int i2 = topBarHeight;
                                int index$iv2 = 0;
                                int size5 = $this$fastForEach$iv.size();
                                while (index$iv2 < size5) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv2);
                                    int i3 = size5;
                                    Placeable it13 = (Placeable) item$iv;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it13, 0, i2, 0.0f, 4, null);
                                    index$iv2++;
                                    size5 = i3;
                                }
                                List $this$fastForEach$iv2 = topBarPlaceables;
                                int size6 = $this$fastForEach$iv2.size();
                                for (int index$iv3 = 0; index$iv3 < size6; index$iv3++) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
                                    Placeable it14 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it14, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv3 = sheetPlaceables2;
                                int size7 = $this$fastForEach$iv3.size();
                                for (int index$iv4 = 0; index$iv4 < size7; index$iv4++) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv4);
                                    Placeable it15 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it15, sheetOffsetX, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv4 = snackbarPlaceables;
                                int index$iv5 = 0;
                                int size8 = $this$fastForEach$iv4.size();
                                while (index$iv5 < size8) {
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv5);
                                    int snackbarOffsetX2 = size8;
                                    Placeable it16 = (Placeable) item$iv4;
                                    int snackbarOffsetX3 = snackbarOffsetX;
                                    int snackbarOffsetY = index$iv;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it16, snackbarOffsetX3, snackbarOffsetY, 0.0f, 4, null);
                                    index$iv5++;
                                    size8 = snackbarOffsetX2;
                                    snackbarOffsetX = snackbarOffsetX3;
                                    index$iv = snackbarOffsetY;
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MultiContentMeasurePolicy measurePolicy$iv = (MultiContentMeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(contents$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, -290761997, "CC(remember):Layout.kt#9igjgp");
            boolean invalid$iv$iv = (((0 & 896) ^ 384) > 256 && $composer2.changed(measurePolicy$iv)) || (0 & 384) == 256;
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy$iv);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = 0 & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            content$iv$iv.invoke($composer2, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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
                    BottomSheetScaffoldKt.m1814BottomSheetScaffoldLayout2E65NiM(modifier, function2, function22, function23, function24, function0, sheetState, containerColor, contentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
