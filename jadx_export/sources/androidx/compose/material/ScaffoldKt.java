package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a§\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u009f\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a¨\u0001\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00192\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b2H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a!\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010;\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m6693constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 1569641925, "C(rememberScaffoldState)71@2725L39,72@2809L32,73@2861L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -694662680, "CC(remember):Scaffold.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:73)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -694660986, "CC(remember):Scaffold.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new ScaffoldState(drawerState, snackbarHostState);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        ScaffoldState scaffoldState = (ScaffoldState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return scaffoldState;
    }

    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    public static final void m1648Scaffoldu4IkXBM(final WindowInsets contentWindowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int floatingActionButtonPosition, final boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2 topBar;
        Function2 bottomBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        int i2;
        int i3;
        int i4;
        int i5;
        int $dirty1;
        int i6;
        int $dirty12;
        long j;
        int $dirty13;
        CornerBasedShape drawerShape2;
        int $dirty14;
        float drawerElevation2;
        boolean isFloatingActionButtonDocked2;
        int $dirty;
        boolean drawerGesturesEnabled2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        int i7;
        long drawerScrimColor2;
        Function3 drawerContent;
        long backgroundColor2;
        long contentColor2;
        int $dirty2;
        long backgroundColor3;
        int $dirty15;
        Function3 drawerContent2;
        boolean drawerGesturesEnabled3;
        Function3 drawerContent3;
        boolean drawerGesturesEnabled4;
        Function3 drawerContent4;
        boolean drawerGesturesEnabled5;
        Composer $composer2;
        final Function2 topBar2;
        final int floatingActionButtonPosition3;
        final boolean isFloatingActionButtonDocked3;
        final Function3 drawerContent5;
        final Modifier modifier3;
        final Shape drawerShape3;
        final Function2 floatingActionButton2;
        final long drawerBackgroundColor3;
        final Function2 bottomBar2;
        final Function3 snackbarHost2;
        final boolean drawerGesturesEnabled6;
        final ScaffoldState scaffoldState3;
        final float drawerElevation3;
        final long drawerContentColor3;
        final long drawerScrimColor3;
        final long backgroundColor4;
        final long contentColor3;
        int $dirty16;
        Composer $composer3 = $composer.startRestartGroup(-1288630565);
        ComposerKt.sourceInformation($composer3, "C(Scaffold)P(4,15,16,18,1,17,12,13:c#material.FabPosition,14,6,9,11,8:c#ui.unit.Dp,5:c#ui.graphics.Color,7:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)184@8354L23,193@8864L6,195@8979L6,196@9027L38,197@9112L10,198@9167L6,199@9212L32,202@9320L86,205@9435L948:Scaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty17 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(contentWindowInsets) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
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
                int i9 = $composer3.changed(scaffoldState2) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty3 |= i9;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i10 = i & 8;
        int i11 = 1024;
        if (i10 != 0) {
            $dirty3 |= 3072;
            topBar = function2;
        } else if (($changed & 3072) == 0) {
            topBar = function2;
            $dirty3 |= $composer3.changedInstance(topBar) ? 2048 : 1024;
        } else {
            topBar = function2;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            bottomBar = function22;
        } else if (($changed & 24576) == 0) {
            bottomBar = function22;
            $dirty3 |= $composer3.changedInstance(bottomBar) ? 16384 : 8192;
        } else {
            bottomBar = function22;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            snackbarHost = function3;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            snackbarHost = function3;
            $dirty3 |= $composer3.changedInstance(snackbarHost) ? 131072 : 65536;
        } else {
            snackbarHost = function3;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty3 |= 1572864;
            floatingActionButton = function23;
        } else if (($changed & 1572864) == 0) {
            floatingActionButton = function23;
            $dirty3 |= $composer3.changedInstance(floatingActionButton) ? 1048576 : 524288;
        } else {
            floatingActionButton = function23;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty3 |= 12582912;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 12582912) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty3 |= $composer3.changed(floatingActionButtonPosition2) ? 8388608 : 4194304;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty3 |= 100663296;
            i2 = i16;
        } else if (($changed & 100663296) == 0) {
            i2 = i16;
            $dirty3 |= $composer3.changed(isFloatingActionButtonDocked) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty3 |= 805306368;
            i3 = i17;
        } else if (($changed & 805306368) == 0) {
            i3 = i17;
            $dirty3 |= $composer3.changedInstance(function32) ? 536870912 : 268435456;
        } else {
            i3 = i17;
        }
        int i18 = i & 1024;
        if (i18 != 0) {
            $dirty17 |= 6;
            i4 = i18;
        } else if (($changed1 & 6) == 0) {
            i4 = i18;
            $dirty17 |= $composer3.changed(drawerGesturesEnabled) ? 4 : 2;
        } else {
            i4 = i18;
        }
        if (($changed1 & 48) == 0) {
            $dirty17 |= ((i & 2048) == 0 && $composer3.changed(drawerShape)) ? 32 : 16;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty17 |= 384;
            i5 = i19;
        } else {
            i5 = i19;
            if (($changed1 & 384) == 0) {
                $dirty17 |= $composer3.changed(drawerElevation) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0) {
                $dirty16 = $dirty17;
                i6 = i8;
                if ($composer3.changed(drawerBackgroundColor)) {
                    i11 = 2048;
                }
            } else {
                $dirty16 = $dirty17;
                i6 = i8;
            }
            $dirty1 = $dirty16 | i11;
        } else {
            $dirty1 = $dirty17;
            i6 = i8;
        }
        int $dirty18 = $dirty1;
        if (($changed1 & 24576) == 0) {
            $dirty12 = $dirty18 | (((i & 16384) == 0 && $composer3.changed(drawerContentColor)) ? 16384 : 8192);
        } else {
            $dirty12 = $dirty18;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty12 |= ((i & 32768) == 0 && $composer3.changed(drawerScrimColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty12 |= ((i & 65536) == 0 && $composer3.changed(backgroundColor)) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            if ((i & 131072) == 0) {
                j = contentColor;
                int i20 = $composer3.changed(j) ? 8388608 : 4194304;
                $dirty12 |= i20;
            } else {
                j = contentColor;
            }
            $dirty12 |= i20;
        } else {
            j = contentColor;
        }
        if ((i & 262144) != 0) {
            $dirty13 = $dirty12 | 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty13 = $dirty12 | ($composer3.changedInstance(function33) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432);
        } else {
            $dirty13 = $dirty12;
        }
        if (($dirty3 & 306783379) == 306783378 && ($dirty13 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerScrimColor3 = drawerScrimColor;
            backgroundColor4 = backgroundColor;
            $composer2 = $composer3;
            contentColor3 = j;
            topBar2 = topBar;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            bottomBar2 = bottomBar;
            snackbarHost2 = snackbarHost;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            floatingActionButton2 = floatingActionButton;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
            drawerContent5 = function32;
            drawerGesturesEnabled6 = drawerGesturesEnabled;
            drawerShape3 = drawerShape;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor3 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    scaffoldState2 = rememberScaffoldState(null, null, $composer3, 0, 3);
                }
                if (i10 != 0) {
                    topBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1524getLambda1$material_release();
                }
                if (i12 != 0) {
                    bottomBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1525getLambda2$material_release();
                }
                if (i13 != 0) {
                    snackbarHost = ComposableSingletons$ScaffoldKt.INSTANCE.m1526getLambda3$material_release();
                }
                if (i14 != 0) {
                    floatingActionButton = ComposableSingletons$ScaffoldKt.INSTANCE.m1527getLambda4$material_release();
                }
                if (i15 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1574getEnd5ygKITE();
                }
                boolean isFloatingActionButtonDocked4 = i2 != 0 ? false : isFloatingActionButtonDocked;
                Function3 drawerContent6 = i3 != 0 ? null : function32;
                boolean drawerGesturesEnabled7 = i4 != 0 ? true : drawerGesturesEnabled;
                if ((i & 2048) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty14 = $dirty13 & (-113);
                } else {
                    drawerShape2 = drawerShape;
                    $dirty14 = $dirty13;
                }
                drawerElevation2 = i5 != 0 ? DrawerDefaults.INSTANCE.m1543getElevationD9Ej5fM() : drawerElevation;
                if ((i & 8192) != 0) {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked4;
                    $dirty = $dirty3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled7;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                    $dirty14 &= -7169;
                } else {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked4;
                    $dirty = $dirty3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled7;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 16384) != 0) {
                    drawerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty14 >> 9) & 14);
                    $dirty14 &= -57345;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((32768 & i) != 0) {
                    i7 = 6;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty14 &= -458753;
                } else {
                    i7 = 6;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                    drawerContent = drawerContent6;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, i7).m1487getBackground0d7_KjU();
                } else {
                    drawerContent = drawerContent6;
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 131072) != 0) {
                    $dirty15 = $dirty14 & (-29360129);
                    isFloatingActionButtonDocked = isFloatingActionButtonDocked2;
                    $dirty2 = $dirty;
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty14 >> 18) & 14);
                    backgroundColor3 = backgroundColor2;
                    drawerContent2 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled2;
                } else {
                    isFloatingActionButtonDocked = isFloatingActionButtonDocked2;
                    contentColor2 = contentColor;
                    $dirty2 = $dirty;
                    backgroundColor3 = backgroundColor2;
                    $dirty15 = $dirty14;
                    drawerContent2 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 2048) != 0) {
                    $dirty13 &= -113;
                }
                $dirty15 = $dirty13;
                if ((i & 8192) != 0) {
                    $dirty15 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty15 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty15 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty15 &= -3670017;
                }
                if ((i & 131072) != 0) {
                    $dirty15 &= -29360129;
                }
                drawerContent2 = function32;
                drawerGesturesEnabled3 = drawerGesturesEnabled;
                drawerElevation2 = drawerElevation;
                drawerContentColor2 = drawerContentColor;
                drawerScrimColor2 = drawerScrimColor;
                backgroundColor3 = backgroundColor;
                $dirty2 = $dirty3;
                contentColor2 = j;
                drawerShape2 = drawerShape;
                drawerBackgroundColor2 = drawerBackgroundColor;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                drawerContent3 = drawerContent2;
                drawerGesturesEnabled4 = drawerGesturesEnabled3;
                ComposerKt.traceEventStart(-1288630565, $dirty2, $dirty15, "androidx.compose.material.Scaffold (Scaffold.kt:201)");
            } else {
                drawerContent3 = drawerContent2;
                drawerGesturesEnabled4 = drawerGesturesEnabled3;
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1364493262, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            int $dirty19 = $dirty15;
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableWindowInsets(contentWindowInsets);
                $composer3.updateRememberedValue(value$iv);
            }
            final MutableWindowInsets safeInsets = (MutableWindowInsets) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Function2 topBar3 = topBar;
            final int floatingActionButtonPosition4 = floatingActionButtonPosition2;
            final Function2 bottomBar3 = bottomBar;
            final Function3 snackbarHost3 = snackbarHost;
            final ScaffoldState scaffoldState4 = scaffoldState2;
            final Function2 floatingActionButton3 = floatingActionButton;
            final long backgroundColor5 = backgroundColor3;
            final long contentColor4 = contentColor2;
            boolean isFloatingActionButtonDocked5 = isFloatingActionButtonDocked;
            final Function3 child = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer, Integer num) {
                    invoke(modifier4, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier childModifier, Composer $composer4, int $changed2) {
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C208@9565L236,214@9890L487,206@9472L905:Scaffold.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty4 |= $composer4.changed(childModifier) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219833176, $dirty5, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:206)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 339309415, "CC(remember):Scaffold.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(safeInsets) | $composer4.changed(contentWindowInsets);
                        final MutableWindowInsets mutableWindowInsets = safeInsets;
                        final WindowInsets windowInsets = contentWindowInsets;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets2) {
                                    invoke2(windowInsets2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(WindowInsets consumedWindowInsets) {
                                    mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, consumedWindowInsets));
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierOnConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(childModifier, (Function1) value$iv2);
                        long j2 = backgroundColor5;
                        long j3 = contentColor4;
                        final boolean z = isFloatingActionButtonDocked;
                        final int i21 = floatingActionButtonPosition4;
                        final Function2<Composer, Integer, Unit> function24 = topBar3;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        final Function2<Composer, Integer, Unit> function25 = floatingActionButton3;
                        final MutableWindowInsets mutableWindowInsets2 = safeInsets;
                        final Function2<Composer, Integer, Unit> function26 = bottomBar3;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function35 = snackbarHost3;
                        final ScaffoldState scaffoldState5 = scaffoldState4;
                        SurfaceKt.m1676SurfaceFjzlyU(modifierOnConsumedWindowInsetsChanged, null, j2, j3, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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
                                ComposerKt.sourceInformation($composer5, "C221@10185L85,215@9904L463:Scaffold.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1772955108, $changed3, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:215)");
                                    }
                                    boolean z2 = z;
                                    int i22 = i21;
                                    Function2<Composer, Integer, Unit> function27 = function24;
                                    Function3<PaddingValues, Composer, Integer, Unit> function36 = function34;
                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function35;
                                    final ScaffoldState scaffoldState6 = scaffoldState5;
                                    ScaffoldKt.m1649ScaffoldLayouti1QSOvI(z2, i22, function27, function36, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            ComposerKt.sourceInformation($composer6, "C222@10207L45:Scaffold.kt#jmzs0o");
                                            if (($changed4 & 3) == 2 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(433906483, $changed4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:222)");
                                            }
                                            function37.invoke(scaffoldState6.getSnackbarHostState(), $composer6, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer5, 54), function25, mutableWindowInsets2, function26, $composer5, 24576);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, 1572864, 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            if (drawerContent3 != null) {
                $composer3.startReplaceGroup(651481999);
                ComposerKt.sourceInformation($composer3, "241@10884L19,231@10426L487");
                long drawerBackgroundColor4 = drawerBackgroundColor2;
                Function3 drawerContent7 = drawerContent3;
                boolean drawerGesturesEnabled8 = drawerGesturesEnabled4;
                DrawerKt.m1546ModalDrawerGs3lGvM(drawerContent7, modifier2, scaffoldState2.getDrawerState(), drawerGesturesEnabled8, drawerShape2, drawerElevation2, drawerBackgroundColor4, drawerContentColor2, drawerScrimColor2, ComposableLambdaKt.rememberComposableLambda(-1409196448, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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
                        ComposerKt.sourceInformation($composer4, "C241@10886L15:Scaffold.kt#jmzs0o");
                        if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1409196448, $changed2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:241)");
                        }
                        child.invoke(Modifier.INSTANCE, $composer4, 54);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty2 >> 27) & 14) | 805306368 | ($dirty2 & 112) | (($dirty19 << 9) & 7168) | (($dirty19 << 9) & 57344) | (($dirty19 << 9) & 458752) | (($dirty19 << 9) & 3670016) | (($dirty19 << 9) & 29360128) | (234881024 & ($dirty19 << 9)), 0);
                drawerContent4 = drawerContent7;
                drawerGesturesEnabled5 = drawerGesturesEnabled8;
                drawerBackgroundColor2 = drawerBackgroundColor4;
                $composer2 = $composer3;
                $composer2.endReplaceGroup();
            } else {
                drawerContent4 = drawerContent3;
                drawerGesturesEnabled5 = drawerGesturesEnabled4;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(651972295);
                ComposerKt.sourceInformation($composer2, "244@10935L15");
                child.invoke(modifier2, $composer2, Integer.valueOf((($dirty2 >> 3) & 14) | 48));
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            topBar2 = topBar;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked5;
            Function2 function24 = bottomBar;
            drawerContent5 = drawerContent4;
            modifier3 = modifier2;
            drawerShape3 = drawerShape2;
            floatingActionButton2 = floatingActionButton;
            drawerBackgroundColor3 = drawerBackgroundColor2;
            bottomBar2 = function24;
            snackbarHost2 = snackbarHost;
            drawerGesturesEnabled6 = drawerGesturesEnabled5;
            scaffoldState3 = scaffoldState2;
            drawerElevation3 = drawerElevation2;
            drawerContentColor3 = drawerContentColor2;
            drawerScrimColor3 = drawerScrimColor2;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer, int i21) {
                    ScaffoldKt.m1648Scaffoldu4IkXBM(contentWindowInsets, modifier3, scaffoldState3, topBar2, bottomBar2, snackbarHost2, floatingActionButton2, floatingActionButtonPosition3, isFloatingActionButtonDocked3, drawerContent5, drawerGesturesEnabled6, drawerShape3, drawerElevation3, drawerBackgroundColor3, drawerContentColor3, drawerScrimColor3, backgroundColor4, contentColor3, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m1647Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2 topBar;
        Function2 bottomBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        int i2;
        int i3;
        int i4;
        int $dirty;
        int $dirty1;
        long j;
        int $dirty12;
        int $dirty2;
        CornerBasedShape drawerShape2;
        int $dirty13;
        float drawerElevation2;
        boolean isFloatingActionButtonDocked2;
        Function3 drawerContent;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long drawerBackgroundColor3;
        long drawerScrimColor2;
        long backgroundColor2;
        boolean drawerGesturesEnabled2;
        Modifier modifier3;
        Function3 snackbarHost2;
        int floatingActionButtonPosition3;
        long drawerBackgroundColor4;
        long drawerContentColor3;
        Function3 drawerContent2;
        long contentColor2;
        long backgroundColor3;
        int $dirty3;
        int $dirty14;
        Shape drawerShape3;
        ScaffoldState scaffoldState3;
        Function2 floatingActionButton2;
        boolean isFloatingActionButtonDocked3;
        Composer $composer2;
        final Modifier modifier4;
        final ScaffoldState scaffoldState4;
        final Function2 topBar2;
        final Function2 bottomBar2;
        final Function3 snackbarHost3;
        final Function2 floatingActionButton3;
        final int floatingActionButtonPosition4;
        final boolean isFloatingActionButtonDocked4;
        final Function3 snackbarHost4;
        final boolean drawerGesturesEnabled3;
        final Shape drawerShape4;
        final float drawerElevation3;
        final long drawerBackgroundColor5;
        final long drawerContentColor4;
        final long drawerScrimColor3;
        final long drawerContentColor5;
        final long drawerScrimColor4;
        int $dirty15;
        Composer $composer3 = $composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation($composer3, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)312@14799L23,321@15309L6,323@15424L6,324@15472L38,325@15557L10,326@15612L6,327@15657L32,330@15748L495:Scaffold.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty16 = $changed1;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty4 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                scaffoldState2 = scaffoldState;
                int i6 = $composer3.changed(scaffoldState2) ? 32 : 16;
                $dirty4 |= i6;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty4 |= i6;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
            topBar = function2;
        } else if (($changed & 384) == 0) {
            topBar = function2;
            $dirty4 |= $composer3.changedInstance(topBar) ? 256 : 128;
        } else {
            topBar = function2;
        }
        int i8 = i & 8;
        int i9 = 2048;
        if (i8 != 0) {
            $dirty4 |= 3072;
            bottomBar = function22;
        } else if (($changed & 3072) == 0) {
            bottomBar = function22;
            $dirty4 |= $composer3.changedInstance(bottomBar) ? 2048 : 1024;
        } else {
            bottomBar = function22;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty4 |= 24576;
            snackbarHost = function3;
        } else if (($changed & 24576) == 0) {
            snackbarHost = function3;
            $dirty4 |= $composer3.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            snackbarHost = function3;
        }
        int i11 = i & 32;
        if (i11 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            floatingActionButton = function23;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            floatingActionButton = function23;
            $dirty4 |= $composer3.changedInstance(floatingActionButton) ? 131072 : 65536;
        } else {
            floatingActionButton = function23;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty4 |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 1572864) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty4 |= $composer3.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i13 = i & 128;
        if (i13 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty4 |= $composer3.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
        }
        int i14 = i & 256;
        if (i14 != 0) {
            $dirty4 |= 100663296;
            i2 = i14;
        } else if (($changed & 100663296) == 0) {
            i2 = i14;
            $dirty4 |= $composer3.changedInstance(function32) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i14;
        }
        int i15 = i & 512;
        if (i15 != 0) {
            $dirty4 |= 805306368;
            i3 = i15;
        } else if (($changed & 805306368) == 0) {
            i3 = i15;
            $dirty4 |= $composer3.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i15;
        }
        if (($changed1 & 6) == 0) {
            $dirty16 |= ((i & 1024) == 0 && $composer3.changed(drawerShape)) ? 4 : 2;
        }
        int i16 = i & 2048;
        if (i16 != 0) {
            $dirty16 |= 48;
            i4 = i16;
        } else if (($changed1 & 48) == 0) {
            i4 = i16;
            $dirty16 |= $composer3.changed(drawerElevation) ? 32 : 16;
        } else {
            i4 = i16;
        }
        if (($changed1 & 384) == 0) {
            if ((i & 4096) == 0) {
                $dirty = $dirty4;
                $dirty15 = $dirty16;
                int i17 = $composer3.changed(drawerBackgroundColor) ? 256 : 128;
                $dirty1 = $dirty15 | i17;
            } else {
                $dirty = $dirty4;
                $dirty15 = $dirty16;
            }
            $dirty1 = $dirty15 | i17;
        } else {
            $dirty = $dirty4;
            $dirty1 = $dirty16;
        }
        int $dirty17 = $dirty1;
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0) {
                j = drawerContentColor;
                if (!$composer3.changed(j)) {
                }
                $dirty12 = $dirty17 | i9;
            } else {
                j = drawerContentColor;
            }
            i9 = 1024;
            $dirty12 = $dirty17 | i9;
        } else {
            j = drawerContentColor;
            $dirty12 = $dirty17;
        }
        int $dirty18 = $dirty12;
        if (($changed1 & 24576) == 0) {
            $dirty18 |= ((i & 16384) == 0 && $composer3.changed(drawerScrimColor)) ? 16384 : 8192;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty18 |= ((i & 32768) == 0 && $composer3.changed(backgroundColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty18 |= ((i & 65536) == 0 && $composer3.changed(contentColor)) ? 1048576 : 524288;
        }
        if ((i & 131072) != 0) {
            $dirty18 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty18 |= $composer3.changedInstance(function33) ? 8388608 : 4194304;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty18 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerContentColor5 = backgroundColor;
            drawerScrimColor4 = contentColor;
            $composer2 = $composer3;
            drawerContentColor4 = j;
            topBar2 = topBar;
            bottomBar2 = bottomBar;
            modifier4 = modifier2;
            scaffoldState4 = scaffoldState2;
            snackbarHost3 = snackbarHost;
            floatingActionButton3 = floatingActionButton;
            floatingActionButtonPosition4 = floatingActionButtonPosition2;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked;
            snackbarHost4 = function32;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerShape4 = drawerShape;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor5 = drawerBackgroundColor;
            drawerScrimColor3 = drawerScrimColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    $dirty2 = $dirty & (-113);
                    scaffoldState2 = rememberScaffoldState(null, null, $composer3, 0, 3);
                } else {
                    $dirty2 = $dirty;
                }
                if (i7 != 0) {
                    topBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1528getLambda5$material_release();
                }
                if (i8 != 0) {
                    bottomBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1529getLambda6$material_release();
                }
                if (i10 != 0) {
                    snackbarHost = ComposableSingletons$ScaffoldKt.INSTANCE.m1530getLambda7$material_release();
                }
                if (i11 != 0) {
                    floatingActionButton = ComposableSingletons$ScaffoldKt.INSTANCE.m1531getLambda8$material_release();
                }
                if (i12 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1574getEnd5ygKITE();
                }
                boolean isFloatingActionButtonDocked5 = i13 != 0 ? false : isFloatingActionButtonDocked;
                Function3 drawerContent3 = i2 != 0 ? null : function32;
                boolean drawerGesturesEnabled4 = i3 != 0 ? true : drawerGesturesEnabled;
                if ((i & 1024) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty13 = $dirty18 & (-15);
                } else {
                    drawerShape2 = drawerShape;
                    $dirty13 = $dirty18;
                }
                drawerElevation2 = i4 != 0 ? DrawerDefaults.INSTANCE.m1543getElevationD9Ej5fM() : drawerElevation;
                if ((i & 4096) != 0) {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    $dirty13 &= -897;
                    drawerContent = drawerContent3;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                } else {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    drawerContent = drawerContent3;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 8192) != 0) {
                    drawerContentColor2 = ColorsKt.m1512contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty13 >> 6) & 14);
                    $dirty13 &= -7169;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 16384) != 0) {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty13 &= -57345;
                } else {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((32768 & i) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1487getBackground0d7_KjU();
                    $dirty13 &= -458753;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 65536) != 0) {
                    long contentColor3 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty13 >> 15) & 14);
                    int i18 = (-3670017) & $dirty13;
                    int $dirty19 = floatingActionButtonPosition2;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    modifier3 = modifier2;
                    snackbarHost2 = snackbarHost;
                    floatingActionButtonPosition3 = $dirty19;
                    long j2 = drawerBackgroundColor3;
                    drawerBackgroundColor4 = drawerContentColor2;
                    drawerContentColor3 = j2;
                    drawerShape3 = drawerShape2;
                    scaffoldState3 = scaffoldState2;
                    floatingActionButton2 = floatingActionButton;
                    contentColor2 = contentColor3;
                    isFloatingActionButtonDocked3 = isFloatingActionButtonDocked2;
                    backgroundColor3 = backgroundColor2;
                    $dirty3 = $dirty2;
                    $dirty14 = i18;
                    drawerContent2 = drawerContent;
                } else {
                    int $dirty110 = floatingActionButtonPosition2;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    modifier3 = modifier2;
                    snackbarHost2 = snackbarHost;
                    floatingActionButtonPosition3 = $dirty110;
                    long j3 = drawerBackgroundColor3;
                    drawerBackgroundColor4 = drawerContentColor2;
                    drawerContentColor3 = j3;
                    drawerContent2 = drawerContent;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    $dirty3 = $dirty2;
                    $dirty14 = $dirty13;
                    drawerShape3 = drawerShape2;
                    scaffoldState3 = scaffoldState2;
                    floatingActionButton2 = floatingActionButton;
                    isFloatingActionButtonDocked3 = isFloatingActionButtonDocked2;
                }
            } else {
                $composer3.skipToGroupEnd();
                $dirty3 = (i & 2) != 0 ? $dirty & (-113) : $dirty;
                if ((i & 1024) != 0) {
                    $dirty18 &= -15;
                }
                $dirty14 = $dirty18;
                if ((i & 4096) != 0) {
                    $dirty14 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty14 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty14 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty14 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                drawerContent2 = function32;
                drawerShape3 = drawerShape;
                drawerElevation2 = drawerElevation;
                drawerContentColor3 = drawerBackgroundColor;
                drawerScrimColor2 = drawerScrimColor;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                drawerBackgroundColor4 = j;
                modifier3 = modifier2;
                scaffoldState3 = scaffoldState2;
                snackbarHost2 = snackbarHost;
                floatingActionButton2 = floatingActionButton;
                floatingActionButtonPosition3 = floatingActionButtonPosition2;
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
                drawerGesturesEnabled2 = drawerGesturesEnabled;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037492569, $dirty3, $dirty14, "androidx.compose.material.Scaffold (Scaffold.kt:329)");
            }
            int $dirty5 = $dirty3;
            $composer2 = $composer3;
            m1648Scaffoldu4IkXBM(WindowInsetsKt.m751WindowInsetsa9UjIt4$default(Dp.m6693constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, topBar, bottomBar, snackbarHost2, floatingActionButton2, floatingActionButtonPosition3, isFloatingActionButtonDocked3, drawerContent2, drawerGesturesEnabled2, drawerShape3, drawerElevation2, drawerContentColor3, drawerBackgroundColor4, drawerScrimColor2, backgroundColor3, contentColor2, function33, $composer2, (($dirty5 << 3) & 112) | (($dirty5 << 3) & 896) | (($dirty5 << 3) & 7168) | (($dirty5 << 3) & 57344) | (($dirty5 << 3) & 458752) | (($dirty5 << 3) & 3670016) | (($dirty5 << 3) & 29360128) | (($dirty5 << 3) & 234881024) | (($dirty5 << 3) & 1879048192), (($dirty5 >> 27) & 14) | (($dirty14 << 3) & 112) | (($dirty14 << 3) & 896) | (($dirty14 << 3) & 7168) | (($dirty14 << 3) & 57344) | (($dirty14 << 3) & 458752) | (($dirty14 << 3) & 3670016) | (($dirty14 << 3) & 29360128) | (($dirty14 << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            scaffoldState4 = scaffoldState3;
            topBar2 = topBar;
            bottomBar2 = bottomBar;
            snackbarHost3 = snackbarHost2;
            floatingActionButton3 = floatingActionButton2;
            floatingActionButtonPosition4 = floatingActionButtonPosition3;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked3;
            snackbarHost4 = drawerContent2;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            drawerShape4 = drawerShape3;
            drawerElevation3 = drawerElevation2;
            drawerBackgroundColor5 = drawerContentColor3;
            drawerContentColor4 = drawerBackgroundColor4;
            drawerScrimColor3 = drawerScrimColor2;
            drawerContentColor5 = backgroundColor3;
            drawerScrimColor4 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$3
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

                public final void invoke(Composer composer, int i19) {
                    ScaffoldKt.m1647Scaffold27mzLpw(modifier4, scaffoldState4, topBar2, bottomBar2, snackbarHost3, floatingActionButton3, floatingActionButtonPosition4, isFloatingActionButtonDocked4, snackbarHost4, drawerGesturesEnabled3, drawerShape4, drawerElevation3, drawerBackgroundColor5, drawerContentColor4, drawerScrimColor3, drawerContentColor5, drawerScrimColor4, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1649ScaffoldLayouti1QSOvI(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        boolean z;
        final int i;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        WindowInsets windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-468424875);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)390@17673L6677,390@17656L6694:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            z = isFabDocked;
            $dirty |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = isFabDocked;
        }
        if (($changed & 48) == 0) {
            i = fabPosition;
            $dirty |= $composer2.changed(i) ? 32 : 16;
        } else {
            i = fabPosition;
        }
        if (($changed & 384) == 0) {
            function25 = function2;
            $dirty |= $composer2.changedInstance(function25) ? 256 : 128;
        } else {
            function25 = function2;
        }
        if (($changed & 3072) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        } else {
            function32 = function3;
        }
        if (($changed & 24576) == 0) {
            function26 = function22;
            $dirty |= $composer2.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function22;
        }
        if ((196608 & $changed) == 0) {
            function27 = function23;
            $dirty |= $composer2.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function23;
        }
        if (($changed & 1572864) == 0) {
            windowInsets = contentWindowInsets;
            $dirty |= $composer2.changed(windowInsets) ? 1048576 : 524288;
        } else {
            windowInsets = contentWindowInsets;
        }
        if (($changed & 12582912) == 0) {
            function28 = function24;
            $dirty |= $composer2.changedInstance(function28) ? 8388608 : 4194304;
        } else {
            function28 = function24;
        }
        if (($dirty & 4793491) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:389)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -771534373, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | ((57344 & $dirty) == 16384) | ((3670016 & $dirty) == 1048576) | ((458752 & $dirty) == 131072) | (($dirty & 112) == 32) | (($dirty & 14) == 4) | ((29360128 & $dirty) == 8388608) | (($dirty & 7168) == 2048);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                final boolean z2 = z;
                final WindowInsets windowInsets2 = windowInsets;
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function32;
                final Function2<? super Composer, ? super Integer, Unit> function29 = function28;
                i2 = 0;
                final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1651invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1651invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        FabPlacement fabPlacement;
                        Object maxElem$iv3;
                        final Integer fabOffsetFromBottom;
                        final int snackbarOffsetFromBottom;
                        Object maxElem$iv4;
                        Object maxElem$iv5;
                        int layoutWidth = Constraints.m6636getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6635getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
                        List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function25);
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int index$iv$iv = 0;
                        int size = $this$fastMap$iv.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            List $this$fastMap$iv2 = $this$fastMap$iv;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            $this$fastMap$iv = $this$fastMap$iv2;
                        }
                        List topBarPlaceables = target$iv;
                        if (topBarPlaceables.isEmpty()) {
                            maxElem$iv = null;
                        } else {
                            maxElem$iv = topBarPlaceables.get(0);
                            Placeable it2 = (Placeable) maxElem$iv;
                            int maxValue$iv = it2.getHeight();
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object e$iv = topBarPlaceables.get(i$iv);
                                    Placeable it3 = (Placeable) e$iv;
                                    int v$iv = it3.getHeight();
                                    if (maxValue$iv < v$iv) {
                                        maxElem$iv = e$iv;
                                        maxValue$iv = v$iv;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) maxElem$iv;
                        final int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                        List $this$fastMap$iv3 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                        WindowInsets windowInsets3 = windowInsets2;
                        int $i$f$fastMap = 0;
                        List target$iv2 = new ArrayList($this$fastMap$iv3.size());
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastMap$iv3.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = $this$fastMap$iv3.get(index$iv$iv2);
                            List $this$fastMap$iv4 = $this$fastMap$iv3;
                            Measurable it4 = (Measurable) item$iv$iv2;
                            List topBarPlaceables2 = topBarPlaceables;
                            int $i$f$fastMap2 = $i$f$fastMap;
                            int leftInset = windowInsets3.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int i3 = size2;
                            int rightInset = windowInsets3.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset = windowInsets3.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets4 = windowInsets3;
                            int i4 = (-leftInset) - rightInset;
                            int leftInset2 = -bottomInset;
                            target$iv2.add(it4.mo5535measureBRTryo0(ConstraintsKt.m6655offsetNN6EwU(looseConstraints, i4, leftInset2)));
                            index$iv$iv2++;
                            $this$fastMap$iv3 = $this$fastMap$iv4;
                            topBarPlaceables = topBarPlaceables2;
                            $i$f$fastMap = $i$f$fastMap2;
                            size2 = i3;
                            windowInsets3 = windowInsets4;
                        }
                        final List topBarPlaceables3 = topBarPlaceables;
                        final List snackbarPlaceables = target$iv2;
                        if (snackbarPlaceables.isEmpty()) {
                            maxElem$iv2 = null;
                        } else {
                            maxElem$iv2 = snackbarPlaceables.get(0);
                            Placeable it5 = (Placeable) maxElem$iv2;
                            int maxValue$iv2 = it5.getHeight();
                            int i$iv2 = 1;
                            int lastIndex2 = CollectionsKt.getLastIndex(snackbarPlaceables);
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object e$iv2 = snackbarPlaceables.get(i$iv2);
                                    Placeable it6 = (Placeable) e$iv2;
                                    int v$iv2 = it6.getHeight();
                                    if (maxValue$iv2 < v$iv2) {
                                        maxElem$iv2 = e$iv2;
                                        maxValue$iv2 = v$iv2;
                                    }
                                    if (i$iv2 == lastIndex2) {
                                        break;
                                    }
                                    i$iv2++;
                                }
                            }
                        }
                        Placeable placeable2 = (Placeable) maxElem$iv2;
                        int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                        List $this$fastMap$iv5 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function210);
                        WindowInsets windowInsets5 = windowInsets2;
                        int $i$f$fastMap3 = 0;
                        ArrayList target$iv3 = new ArrayList($this$fastMap$iv5.size());
                        List $this$fastForEach$iv$iv = $this$fastMap$iv5;
                        int $i$f$fastForEach = 0;
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastForEach$iv$iv.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = $this$fastForEach$iv$iv.get(index$iv$iv3);
                            List $this$fastMap$iv6 = $this$fastMap$iv5;
                            ArrayList arrayList = target$iv3;
                            int $i$f$fastMap4 = $i$f$fastMap3;
                            Measurable measurable = (Measurable) item$iv$iv3;
                            ArrayList target$iv4 = target$iv3;
                            List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                            int leftInset3 = windowInsets5.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int $i$f$fastForEach2 = $i$f$fastForEach;
                            int rightInset2 = windowInsets5.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset2 = windowInsets5.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets6 = windowInsets5;
                            int i5 = (-leftInset3) - rightInset2;
                            int leftInset4 = -bottomInset2;
                            arrayList.add(measurable.mo5535measureBRTryo0(ConstraintsKt.m6655offsetNN6EwU(looseConstraints, i5, leftInset4)));
                            index$iv$iv3++;
                            $this$fastMap$iv5 = $this$fastMap$iv6;
                            $i$f$fastMap3 = $i$f$fastMap4;
                            target$iv3 = target$iv4;
                            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                            $i$f$fastForEach = $i$f$fastForEach2;
                            windowInsets5 = windowInsets6;
                        }
                        final ArrayList fabPlaceables = target$iv3;
                        if (fabPlaceables.isEmpty()) {
                            fabPlacement = null;
                        } else {
                            if (fabPlaceables.isEmpty()) {
                                maxElem$iv4 = null;
                            } else {
                                maxElem$iv4 = fabPlaceables.get(0);
                                Placeable it7 = (Placeable) maxElem$iv4;
                                int maxValue$iv3 = it7.getWidth();
                                int i$iv3 = 1;
                                int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex3) {
                                    while (true) {
                                        Object e$iv3 = fabPlaceables.get(i$iv3);
                                        Placeable it8 = (Placeable) e$iv3;
                                        int v$iv3 = it8.getWidth();
                                        if (maxValue$iv3 < v$iv3) {
                                            maxElem$iv4 = e$iv3;
                                            maxValue$iv3 = v$iv3;
                                        }
                                        if (i$iv3 == lastIndex3) {
                                            break;
                                        }
                                        i$iv3++;
                                    }
                                }
                            }
                            Placeable placeable3 = (Placeable) maxElem$iv4;
                            int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                            List $this$fastMaxBy$iv = fabPlaceables;
                            if ($this$fastMaxBy$iv.isEmpty()) {
                                maxElem$iv5 = null;
                            } else {
                                maxElem$iv5 = $this$fastMaxBy$iv.get(0);
                                Placeable it9 = (Placeable) maxElem$iv5;
                                int maxValue$iv4 = it9.getHeight();
                                int i$iv4 = 1;
                                int lastIndex4 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                                if (1 <= lastIndex4) {
                                    while (true) {
                                        Object e$iv4 = $this$fastMaxBy$iv.get(i$iv4);
                                        Placeable it10 = (Placeable) e$iv4;
                                        int height = it10.getHeight();
                                        List $this$fastMaxBy$iv2 = $this$fastMaxBy$iv;
                                        if (maxValue$iv4 < height) {
                                            maxElem$iv5 = e$iv4;
                                            maxValue$iv4 = height;
                                        }
                                        if (i$iv4 == lastIndex4) {
                                            break;
                                        }
                                        i$iv4++;
                                        $this$fastMaxBy$iv = $this$fastMaxBy$iv2;
                                    }
                                }
                            }
                            Placeable placeable4 = (Placeable) maxElem$iv5;
                            int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                            if (fabWidth == 0 || fabHeight == 0) {
                                fabPlacement = null;
                            } else {
                                int i6 = i;
                                int fabLeftOffset = FabPosition.m1569equalsimpl0(i6, FabPosition.INSTANCE.m1575getStart5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : FabPosition.m1569equalsimpl0(i6, FabPosition.INSTANCE.m1574getEnd5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - fabWidth) / 2;
                                fabPlacement = new FabPlacement(z2, fabLeftOffset, fabWidth, fabHeight);
                            }
                        }
                        final FabPlacement fabPlacement2 = fabPlacement;
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function211 = function29;
                        List $this$fastMap$iv7 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(424088350, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
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
                                ComposerKt.sourceInformation($composer3, "C475@21173L132:Scaffold.kt#jmzs0o");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(424088350, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:475)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(fabPlacement2), function211, $composer3, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        int $i$f$fastMap5 = 0;
                        List target$iv5 = new ArrayList($this$fastMap$iv7.size());
                        int index$iv$iv4 = 0;
                        int size4 = $this$fastMap$iv7.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = $this$fastMap$iv7.get(index$iv$iv4);
                            int $i$f$fastMap6 = $i$f$fastMap5;
                            Measurable it11 = (Measurable) item$iv$iv4;
                            target$iv5.add(it11.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            $this$fastMap$iv7 = $this$fastMap$iv7;
                            $i$f$fastMap5 = $i$f$fastMap6;
                        }
                        final List bottomBarPlaceables = target$iv5;
                        List $this$fastMaxBy$iv3 = bottomBarPlaceables;
                        if ($this$fastMaxBy$iv3.isEmpty()) {
                            maxElem$iv3 = null;
                        } else {
                            maxElem$iv3 = $this$fastMaxBy$iv3.get(0);
                            Placeable it12 = (Placeable) maxElem$iv3;
                            int maxValue$iv5 = it12.getHeight();
                            int i$iv5 = 1;
                            int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv3);
                            if (1 <= lastIndex5) {
                                while (true) {
                                    Object e$iv5 = $this$fastMaxBy$iv3.get(i$iv5);
                                    Placeable it13 = (Placeable) e$iv5;
                                    int height2 = it13.getHeight();
                                    List $this$fastMaxBy$iv4 = $this$fastMaxBy$iv3;
                                    if (maxValue$iv5 < height2) {
                                        maxElem$iv3 = e$iv5;
                                        maxValue$iv5 = height2;
                                    }
                                    if (i$iv5 == lastIndex5) {
                                        break;
                                    }
                                    i$iv5++;
                                    $this$fastMaxBy$iv3 = $this$fastMaxBy$iv4;
                                }
                            }
                        }
                        Placeable placeable5 = (Placeable) maxElem$iv3;
                        final Integer bottomBarHeight = placeable5 != null ? Integer.valueOf(placeable5.getHeight()) : null;
                        if (fabPlacement2 != null) {
                            fabOffsetFromBottom = Integer.valueOf(bottomBarHeight == null ? fabPlacement2.getHeight() + $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets2.getBottom($this$SubcomposeLayout) : z2 ? (fabPlacement2.getHeight() / 2) + bottomBarHeight.intValue() : $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) + bottomBarHeight.intValue() + fabPlacement2.getHeight());
                        } else {
                            fabOffsetFromBottom = null;
                        }
                        if (snackbarHeight != 0) {
                            snackbarOffsetFromBottom = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : windowInsets2.getBottom($this$SubcomposeLayout));
                        } else {
                            snackbarOffsetFromBottom = 0;
                        }
                        int bodyContentHeight = layoutHeight - topBarHeight;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets7 = windowInsets2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        List $this$fastMap$iv8 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-570781649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
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
                                float fM6693constructorimpl;
                                float bottom;
                                ComposerKt.sourceInformation($composer3, "C526@23329L21:Scaffold.kt#jmzs0o");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-570781649, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:509)");
                                    }
                                    PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets7, $this$SubcomposeLayout);
                                    if (topBarPlaceables3.isEmpty()) {
                                        fM6693constructorimpl = insets.getTop();
                                    } else {
                                        fM6693constructorimpl = Dp.m6693constructorimpl(0);
                                    }
                                    if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                        bottom = insets.getBottom();
                                    } else {
                                        bottom = $this$SubcomposeLayout.mo364toDpu2uoSUM(bottomBarHeight.intValue());
                                    }
                                    PaddingValues innerPadding = PaddingKt.m677PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), fM6693constructorimpl, PaddingKt.calculateEndPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), bottom);
                                    function34.invoke(innerPadding, $composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        List target$iv6 = new ArrayList($this$fastMap$iv8.size());
                        int size5 = $this$fastMap$iv8.size();
                        int index$iv$iv5 = 0;
                        while (index$iv$iv5 < size5) {
                            Object item$iv$iv5 = $this$fastMap$iv8.get(index$iv$iv5);
                            int index$iv$iv6 = index$iv$iv5;
                            Measurable it14 = (Measurable) item$iv$iv5;
                            long looseConstraints2 = looseConstraints;
                            target$iv6.add(it14.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(looseConstraints2, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(looseConstraints2) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(looseConstraints2) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(looseConstraints2) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(looseConstraints2) : bodyContentHeight)));
                            index$iv$iv5 = index$iv$iv6 + 1;
                            size5 = size5;
                            looseConstraints = looseConstraints2;
                        }
                        final List bodyContentPlaceables = target$iv6;
                        final Integer bottomBarHeight2 = bottomBarHeight;
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                List $this$fastForEach$iv = bodyContentPlaceables;
                                int i7 = topBarHeight;
                                int size6 = $this$fastForEach$iv.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it15, 0, i7, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv2 = topBarPlaceables3;
                                int size7 = $this$fastForEach$iv2.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it16, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv3 = snackbarPlaceables;
                                int i8 = layoutHeight;
                                int i9 = snackbarOffsetFromBottom;
                                int size8 = $this$fastForEach$iv3.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it17, 0, i8 - i9, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv4 = bottomBarPlaceables;
                                int i10 = layoutHeight;
                                Integer num = bottomBarHeight2;
                                int index$iv4 = 0;
                                int size9 = $this$fastForEach$iv4.size();
                                while (true) {
                                    int iIntValue = 0;
                                    if (index$iv4 >= size9) {
                                        break;
                                    }
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    if (num != null) {
                                        iIntValue = num.intValue();
                                    }
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, i10 - iIntValue, 0.0f, 4, null);
                                    index$iv4++;
                                }
                                List $this$fastForEach$iv5 = fabPlaceables;
                                FabPlacement fabPlacement3 = fabPlacement2;
                                int i11 = layoutHeight;
                                Integer num2 = fabOffsetFromBottom;
                                int size10 = $this$fastForEach$iv5.size();
                                for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                    Object item$iv5 = $this$fastForEach$iv5.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default($this$layout, it19, fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i11 - (num2 != null ? num2.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                i2 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv, $composer2, i2, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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

                public final void invoke(Composer composer, int i3) {
                    ScaffoldKt.m1649ScaffoldLayouti1QSOvI(isFabDocked, fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
