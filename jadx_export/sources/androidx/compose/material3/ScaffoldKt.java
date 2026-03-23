package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a±\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0087\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\t2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final float FabSpacing = Dp.m6693constructorimpl(16);

    /* renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m2426ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int floatingActionButtonPosition, long containerColor, long contentColor, WindowInsets contentWindowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 topBar;
        Function2 bottomBar;
        Function2 snackbarHost;
        Function2 floatingActionButton;
        int $dirty;
        int i2;
        int floatingActionButtonPosition2;
        long containerColor2;
        int i3;
        int i4;
        long contentColor2;
        final WindowInsets contentWindowInsets2;
        int $dirty2;
        long containerColor3;
        final int floatingActionButtonPosition3;
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        final Modifier modifier3;
        final Function2 topBar2;
        final WindowInsets contentWindowInsets3;
        final Function2 snackbarHost2;
        final long contentColor3;
        final int floatingActionButtonPosition4;
        final Function2 bottomBar2;
        final long containerColor4;
        final Function2 floatingActionButton2;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-1219521777);
        ComposerKt.sourceInformation($composer3, "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)90@4654L11,91@4704L31,92@4794L19,95@4889L74,98@5047L224,104@5347L314,96@4968L693:Scaffold.kt#uh7d8r");
        int $dirty4 = $changed;
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
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty4 |= 48;
            topBar = function2;
        } else if (($changed & 48) == 0) {
            topBar = function2;
            $dirty4 |= $composer3.changedInstance(topBar) ? 32 : 16;
        } else {
            topBar = function2;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
            bottomBar = function22;
        } else if (($changed & 384) == 0) {
            bottomBar = function22;
            $dirty4 |= $composer3.changedInstance(bottomBar) ? 256 : 128;
        } else {
            bottomBar = function22;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
            snackbarHost = function23;
        } else if (($changed & 3072) == 0) {
            snackbarHost = function23;
            $dirty4 |= $composer3.changedInstance(snackbarHost) ? 2048 : 1024;
        } else {
            snackbarHost = function23;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
            floatingActionButton = function24;
        } else if (($changed & 24576) == 0) {
            floatingActionButton = function24;
            $dirty4 |= $composer3.changedInstance(floatingActionButton) ? 16384 : 8192;
        } else {
            floatingActionButton = function24;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty4 |= $composer3.changed(floatingActionButtonPosition) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                i2 = i5;
                int i11 = $composer3.changed(containerColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i11;
            } else {
                $dirty3 = $dirty4;
                i2 = i5;
            }
            $dirty = $dirty3 | i11;
        } else {
            $dirty = $dirty4;
            i2 = i5;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(contentColor)) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(contentWindowInsets)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentWindowInsets3 = contentWindowInsets;
            $composer2 = $composer3;
            modifier3 = modifier2;
            topBar2 = topBar;
            bottomBar2 = bottomBar;
            snackbarHost2 = snackbarHost;
            floatingActionButtonPosition4 = floatingActionButtonPosition;
            containerColor4 = containerColor;
            contentColor3 = contentColor;
            floatingActionButton2 = floatingActionButton;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    topBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1992getLambda1$material3_release();
                }
                if (i7 != 0) {
                    bottomBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1993getLambda2$material3_release();
                }
                if (i8 != 0) {
                    snackbarHost = ComposableSingletons$ScaffoldKt.INSTANCE.m1994getLambda3$material3_release();
                }
                if (i9 != 0) {
                    floatingActionButton = ComposableSingletons$ScaffoldKt.INSTANCE.m1995getLambda4$material3_release();
                }
                floatingActionButtonPosition2 = i10 != 0 ? FabPosition.INSTANCE.m2123getEndERTFSPs() : floatingActionButtonPosition;
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getBackground();
                    i3 = -29360129;
                    i4 = -234881025;
                } else {
                    containerColor2 = containerColor;
                    i3 = -29360129;
                    i4 = -234881025;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorSchemeKt.m1948contentColorForek8zF_U(containerColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= i3;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 256) != 0) {
                    contentWindowInsets2 = ScaffoldDefaults.INSTANCE.getContentWindowInsets($composer3, 6);
                    $dirty2 = $dirty & i4;
                    containerColor3 = containerColor2;
                } else {
                    contentWindowInsets2 = contentWindowInsets;
                    $dirty2 = $dirty;
                    containerColor3 = containerColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i12 = $dirty & (-234881025);
                    containerColor3 = containerColor;
                    contentColor2 = contentColor;
                    contentWindowInsets2 = contentWindowInsets;
                    $dirty2 = i12;
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                } else {
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                    contentColor2 = contentColor;
                    contentWindowInsets2 = contentWindowInsets;
                    $dirty2 = $dirty;
                    containerColor3 = containerColor;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1219521777, $dirty2, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:94)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (((234881024 & $dirty2) ^ 100663296) > 67108864 && $composer3.changed(contentWindowInsets2)) || ($dirty2 & 100663296) == 67108864;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                floatingActionButtonPosition3 = floatingActionButtonPosition2;
                value$iv = new MutableWindowInsets(contentWindowInsets2);
                $composer3.updateRememberedValue(value$iv);
            } else {
                floatingActionButtonPosition3 = floatingActionButtonPosition2;
                value$iv = it$iv;
            }
            final MutableWindowInsets safeInsets = (MutableWindowInsets) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(safeInsets) | ((((234881024 & $dirty2) ^ 100663296) > 67108864 && $composer3.changed(contentWindowInsets2)) || ($dirty2 & 100663296) == 67108864);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets) {
                        invoke2(windowInsets);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets consumedWindowInsets) {
                        safeInsets.setInsets(WindowInsetsKt.exclude(contentWindowInsets2, consumedWindowInsets));
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Function2 topBar3 = topBar;
            final Function2 bottomBar3 = bottomBar;
            final Function2 snackbarHost3 = snackbarHost;
            final Function2 floatingActionButton3 = floatingActionButton;
            int floatingActionButtonPosition5 = floatingActionButtonPosition3;
            long contentColor4 = contentColor2;
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) value$iv2), null, containerColor3, contentColor4, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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
                    ComposerKt.sourceInformation($composer4, "C105@5357L298:Scaffold.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1979205334, $changed2, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                        }
                        ScaffoldKt.m2427ScaffoldLayoutFMILGgc(floatingActionButtonPosition3, topBar3, function3, snackbarHost3, floatingActionButton3, safeInsets, bottomBar3, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 12) & 896) | 12582912 | (($dirty2 >> 12) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            topBar2 = topBar;
            contentWindowInsets3 = contentWindowInsets2;
            snackbarHost2 = snackbarHost;
            contentColor3 = contentColor4;
            floatingActionButtonPosition4 = floatingActionButtonPosition5;
            bottomBar2 = bottomBar;
            containerColor4 = containerColor3;
            floatingActionButton2 = floatingActionButton;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$3
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

                public final void invoke(Composer composer, int i13) {
                    ScaffoldKt.m2426ScaffoldTvnljyQ(modifier3, topBar2, bottomBar2, snackbarHost2, floatingActionButton2, floatingActionButtonPosition4, containerColor4, contentColor3, contentWindowInsets3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m2427ScaffoldLayoutFMILGgc(final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        final int i;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        WindowInsets windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)139@6582L6951,139@6565L6968:Scaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            i = fabPosition;
            $dirty |= $composer2.changed(i) ? 4 : 2;
        } else {
            i = fabPosition;
        }
        if (($changed & 48) == 0) {
            function25 = function2;
            $dirty |= $composer2.changedInstance(function25) ? 32 : 16;
        } else {
            function25 = function2;
        }
        if (($changed & 384) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? 256 : 128;
        } else {
            function32 = function3;
        }
        if (($changed & 3072) == 0) {
            function26 = function22;
            $dirty |= $composer2.changedInstance(function26) ? 2048 : 1024;
        } else {
            function26 = function22;
        }
        if (($changed & 24576) == 0) {
            function27 = function23;
            $dirty |= $composer2.changedInstance(function27) ? 16384 : 8192;
        } else {
            function27 = function23;
        }
        if ((196608 & $changed) == 0) {
            windowInsets = contentWindowInsets;
            $dirty |= $composer2.changed(windowInsets) ? 131072 : 65536;
        } else {
            windowInsets = contentWindowInsets;
        }
        if (($changed & 1572864) == 0) {
            function28 = function24;
            $dirty |= $composer2.changedInstance(function28) ? 1048576 : 524288;
        } else {
            function28 = function24;
        }
        if (($dirty & 599187) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, $dirty, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1690368138, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 7168) == 2048) | ((458752 & $dirty) == 131072) | ((57344 & $dirty) == 16384) | (($dirty & 14) == 4) | ((3670016 & $dirty) == 1048576) | (($dirty & 896) == 256);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function32;
                final Function2<? super Composer, ? super Integer, Unit> function29 = function28;
                i2 = 0;
                final WindowInsets windowInsets2 = windowInsets;
                value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m2429invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2429invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        Object maxElem$iv3;
                        final int layoutWidth;
                        FabPlacement fabPlacement;
                        Object maxElem$iv4;
                        Object maxElem$iv5;
                        Object maxElem$iv6;
                        int layoutWidth2 = Constraints.m6636getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6635getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
                        List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function25);
                        int $i$f$fastMap = 0;
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int index$iv$iv = 0;
                        int size = $this$fastMap$iv.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            int $i$f$fastMap2 = $i$f$fastMap;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            $this$fastMap$iv = $this$fastMap$iv;
                            $i$f$fastMap = $i$f$fastMap2;
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
                                    int height = it3.getHeight();
                                    if (maxValue$iv < height) {
                                        maxElem$iv = e$iv;
                                        maxValue$iv = height;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) maxElem$iv;
                        int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                        List $this$fastMap$iv2 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                        WindowInsets windowInsets3 = windowInsets2;
                        int $i$f$fastMap3 = 0;
                        List target$iv2 = new ArrayList($this$fastMap$iv2.size());
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastMap$iv2.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = $this$fastMap$iv2.get(index$iv$iv2);
                            List topBarPlaceables2 = topBarPlaceables;
                            Measurable it4 = (Measurable) item$iv$iv2;
                            int topBarHeight2 = topBarHeight;
                            int $i$f$fastMap4 = $i$f$fastMap3;
                            int leftInset = windowInsets3.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int i3 = size2;
                            int rightInset = windowInsets3.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset = windowInsets3.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets4 = windowInsets3;
                            int i4 = (-leftInset) - rightInset;
                            int leftInset2 = -bottomInset;
                            target$iv2.add(it4.mo5535measureBRTryo0(ConstraintsKt.m6655offsetNN6EwU(looseConstraints, i4, leftInset2)));
                            index$iv$iv2++;
                            $this$fastMap$iv2 = $this$fastMap$iv2;
                            topBarPlaceables = topBarPlaceables2;
                            topBarHeight = topBarHeight2;
                            $i$f$fastMap3 = $i$f$fastMap4;
                            size2 = i3;
                            windowInsets3 = windowInsets4;
                        }
                        final List topBarPlaceables3 = topBarPlaceables;
                        final int topBarHeight3 = topBarHeight;
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
                                    int v$iv = it6.getHeight();
                                    if (maxValue$iv2 < v$iv) {
                                        maxElem$iv2 = e$iv2;
                                        maxValue$iv2 = v$iv;
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
                        if (snackbarPlaceables.isEmpty()) {
                            maxElem$iv3 = null;
                        } else {
                            maxElem$iv3 = snackbarPlaceables.get(0);
                            Placeable it7 = (Placeable) maxElem$iv3;
                            int maxValue$iv3 = it7.getWidth();
                            int i$iv3 = 1;
                            int lastIndex3 = CollectionsKt.getLastIndex(snackbarPlaceables);
                            if (1 <= lastIndex3) {
                                while (true) {
                                    Object e$iv3 = snackbarPlaceables.get(i$iv3);
                                    Placeable it8 = (Placeable) e$iv3;
                                    int v$iv2 = it8.getWidth();
                                    if (maxValue$iv3 < v$iv2) {
                                        maxElem$iv3 = e$iv3;
                                        maxValue$iv3 = v$iv2;
                                    }
                                    if (i$iv3 == lastIndex3) {
                                        break;
                                    }
                                    i$iv3++;
                                }
                            }
                        }
                        Placeable placeable3 = (Placeable) maxElem$iv3;
                        final int snackbarWidth = placeable3 != null ? placeable3.getWidth() : 0;
                        List $this$fastMapNotNull$iv = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function27);
                        WindowInsets windowInsets5 = windowInsets2;
                        int $i$f$fastMapNotNull = 0;
                        ArrayList target$iv3 = new ArrayList($this$fastMapNotNull$iv.size());
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastMapNotNull$iv.size();
                        while (true) {
                            layoutWidth = layoutWidth2;
                            if (index$iv$iv3 >= size3) {
                                break;
                            }
                            Object item$iv$iv3 = $this$fastMapNotNull$iv.get(index$iv$iv3);
                            Measurable measurable = (Measurable) item$iv$iv3;
                            List $this$fastMapNotNull$iv2 = $this$fastMapNotNull$iv;
                            int $i$f$fastMapNotNull2 = $i$f$fastMapNotNull;
                            int leftInset3 = windowInsets5.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            ArrayList target$iv4 = target$iv3;
                            int rightInset2 = windowInsets5.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset2 = windowInsets5.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets6 = windowInsets5;
                            int i5 = (-leftInset3) - rightInset2;
                            int leftInset4 = -bottomInset2;
                            Placeable it9 = measurable.mo5535measureBRTryo0(ConstraintsKt.m6655offsetNN6EwU(looseConstraints, i5, leftInset4));
                            if (!((it9.getHeight() == 0 || it9.getWidth() == 0) ? false : true)) {
                                it9 = null;
                            }
                            if (it9 != null) {
                                target$iv4.add(it9);
                            }
                            index$iv$iv3++;
                            layoutWidth2 = layoutWidth;
                            $this$fastMapNotNull$iv = $this$fastMapNotNull$iv2;
                            $i$f$fastMapNotNull = $i$f$fastMapNotNull2;
                            target$iv3 = target$iv4;
                            windowInsets5 = windowInsets6;
                        }
                        final ArrayList fabPlaceables = target$iv3;
                        if (fabPlaceables.isEmpty()) {
                            fabPlacement = null;
                        } else {
                            if (fabPlaceables.isEmpty()) {
                                maxElem$iv5 = null;
                            } else {
                                maxElem$iv5 = fabPlaceables.get(0);
                                Placeable it10 = (Placeable) maxElem$iv5;
                                int maxValue$iv4 = it10.getWidth();
                                int i$iv4 = 1;
                                int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex4) {
                                    while (true) {
                                        Object e$iv4 = fabPlaceables.get(i$iv4);
                                        Placeable it11 = (Placeable) e$iv4;
                                        int v$iv3 = it11.getWidth();
                                        if (maxValue$iv4 < v$iv3) {
                                            maxElem$iv5 = e$iv4;
                                            maxValue$iv4 = v$iv3;
                                        }
                                        if (i$iv4 == lastIndex4) {
                                            break;
                                        }
                                        i$iv4++;
                                    }
                                }
                            }
                            Intrinsics.checkNotNull(maxElem$iv5);
                            int fabWidth = ((Placeable) maxElem$iv5).getWidth();
                            List $this$fastMaxBy$iv = fabPlaceables;
                            if ($this$fastMaxBy$iv.isEmpty()) {
                                maxElem$iv6 = null;
                            } else {
                                maxElem$iv6 = $this$fastMaxBy$iv.get(0);
                                Placeable it12 = (Placeable) maxElem$iv6;
                                int maxValue$iv5 = it12.getHeight();
                                int i$iv5 = 1;
                                int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                                if (1 <= lastIndex5) {
                                    while (true) {
                                        Object e$iv5 = $this$fastMaxBy$iv.get(i$iv5);
                                        Placeable it13 = (Placeable) e$iv5;
                                        int height2 = it13.getHeight();
                                        List $this$fastMaxBy$iv2 = $this$fastMaxBy$iv;
                                        if (maxValue$iv5 < height2) {
                                            maxElem$iv6 = e$iv5;
                                            maxValue$iv5 = height2;
                                        }
                                        if (i$iv5 == lastIndex5) {
                                            break;
                                        }
                                        i$iv5++;
                                        $this$fastMaxBy$iv = $this$fastMaxBy$iv2;
                                    }
                                }
                            }
                            Intrinsics.checkNotNull(maxElem$iv6);
                            int fabHeight = ((Placeable) maxElem$iv6).getHeight();
                            int i6 = i;
                            int fabLeftOffset = FabPosition.m2118equalsimpl0(i6, FabPosition.INSTANCE.m2125getStartERTFSPs()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : FabPosition.m2118equalsimpl0(i6, FabPosition.INSTANCE.m2123getEndERTFSPs()) ? true : FabPosition.m2118equalsimpl0(i6, FabPosition.INSTANCE.m2124getEndOverlayERTFSPs()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - fabWidth) / 2;
                            fabPlacement = new FabPlacement(fabLeftOffset, fabWidth, fabHeight);
                        }
                        final FabPlacement fabPlacement2 = fabPlacement;
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function210 = function29;
                        List $this$fastMap$iv3 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
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
                                ComposerKt.sourceInformation($composer3, "C209@10015L11:Scaffold.kt#uh7d8r");
                                if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2146438447, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:209)");
                                }
                                function210.invoke($composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        int $i$f$fastMap5 = 0;
                        List target$iv5 = new ArrayList($this$fastMap$iv3.size());
                        int index$iv$iv4 = 0;
                        int size4 = $this$fastMap$iv3.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = $this$fastMap$iv3.get(index$iv$iv4);
                            int $i$f$fastMap6 = $i$f$fastMap5;
                            Measurable it14 = (Measurable) item$iv$iv4;
                            target$iv5.add(it14.mo5535measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            $this$fastMap$iv3 = $this$fastMap$iv3;
                            $i$f$fastMap5 = $i$f$fastMap6;
                        }
                        final List bottomBarPlaceables = target$iv5;
                        List $this$fastMaxBy$iv3 = bottomBarPlaceables;
                        if ($this$fastMaxBy$iv3.isEmpty()) {
                            maxElem$iv4 = null;
                        } else {
                            maxElem$iv4 = $this$fastMaxBy$iv3.get(0);
                            Placeable it15 = (Placeable) maxElem$iv4;
                            int maxValue$iv6 = it15.getHeight();
                            int i$iv6 = 1;
                            int lastIndex6 = CollectionsKt.getLastIndex($this$fastMaxBy$iv3);
                            if (1 <= lastIndex6) {
                                while (true) {
                                    Object e$iv6 = $this$fastMaxBy$iv3.get(i$iv6);
                                    Placeable it16 = (Placeable) e$iv6;
                                    int height3 = it16.getHeight();
                                    List $this$fastMaxBy$iv4 = $this$fastMaxBy$iv3;
                                    if (maxValue$iv6 < height3) {
                                        maxElem$iv4 = e$iv6;
                                        maxValue$iv6 = height3;
                                    }
                                    if (i$iv6 == lastIndex6) {
                                        break;
                                    }
                                    i$iv6++;
                                    $this$fastMaxBy$iv3 = $this$fastMaxBy$iv4;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) maxElem$iv4;
                        final Integer bottomBarHeight = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        final Integer fabOffsetFromBottom = fabPlacement2 != null ? Integer.valueOf((bottomBarHeight == null || FabPosition.m2118equalsimpl0(i, FabPosition.INSTANCE.m2124getEndOverlayERTFSPs())) ? fabPlacement2.getHeight() + $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets2.getBottom($this$SubcomposeLayout) : bottomBarHeight.intValue() + fabPlacement2.getHeight() + $this$SubcomposeLayout.mo361roundToPx0680j_4(ScaffoldKt.FabSpacing)) : null;
                        int snackbarOffsetFromBottom = snackbarHeight != 0 ? snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : windowInsets2.getBottom($this$SubcomposeLayout)) : 0;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets7 = windowInsets2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        List $this$fastMap$iv4 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
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
                                float top;
                                float bottom;
                                ComposerKt.sourceInformation($composer3, "C260@12377L21:Scaffold.kt#uh7d8r");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1213360416, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:238)");
                                    }
                                    PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets7, $this$SubcomposeLayout);
                                    if (topBarPlaceables3.isEmpty()) {
                                        top = insets.getTop();
                                    } else {
                                        top = $this$SubcomposeLayout.mo364toDpu2uoSUM(topBarHeight3);
                                    }
                                    if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                        bottom = insets.getBottom();
                                    } else {
                                        bottom = $this$SubcomposeLayout.mo364toDpu2uoSUM(bottomBarHeight.intValue());
                                    }
                                    PaddingValues innerPadding = PaddingKt.m677PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), top, PaddingKt.calculateEndPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), bottom);
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
                        List target$iv6 = new ArrayList($this$fastMap$iv4.size());
                        int $i$f$fastMap7 = 0;
                        for (int size5 = $this$fastMap$iv4.size(); $i$f$fastMap7 < size5; size5 = size5) {
                            Object item$iv$iv5 = $this$fastMap$iv4.get($i$f$fastMap7);
                            int index$iv$iv5 = $i$f$fastMap7;
                            Measurable it17 = (Measurable) item$iv$iv5;
                            target$iv6.add(it17.mo5535measureBRTryo0(looseConstraints));
                            $i$f$fastMap7 = index$iv$iv5 + 1;
                        }
                        final List bodyContentPlaceables = target$iv6;
                        final WindowInsets windowInsets8 = windowInsets2;
                        final int snackbarWidth2 = snackbarOffsetFromBottom;
                        final Integer bottomBarHeight2 = bottomBarHeight;
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                int size6 = $this$fastForEach$iv.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                    Placeable it18 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv2 = topBarPlaceables3;
                                int size7 = $this$fastForEach$iv2.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                                    Placeable it19 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it19, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv3 = snackbarPlaceables;
                                int i7 = layoutWidth;
                                int i8 = snackbarWidth;
                                WindowInsets windowInsets9 = windowInsets8;
                                SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                int i9 = layoutHeight;
                                int i10 = snackbarWidth2;
                                int index$iv3 = 0;
                                int size8 = $this$fastForEach$iv3.size();
                                while (index$iv3 < size8) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                                    Placeable it20 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it20, ((i7 - i8) / 2) + windowInsets9.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), i9 - i10, 0.0f, 4, null);
                                    index$iv3++;
                                    $this$fastForEach$iv3 = $this$fastForEach$iv3;
                                }
                                List $this$fastForEach$iv4 = bottomBarPlaceables;
                                int i11 = layoutHeight;
                                Integer num = bottomBarHeight2;
                                int size9 = $this$fastForEach$iv4.size();
                                for (int index$iv4 = 0; index$iv4 < size9; index$iv4++) {
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv4);
                                    Placeable it21 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.place$default($this$layout, it21, 0, i11 - (num != null ? num.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement placement = fabPlacement2;
                                if (placement != null) {
                                    List $this$fastForEach$iv5 = fabPlaceables;
                                    int i12 = layoutHeight;
                                    Integer num2 = fabOffsetFromBottom;
                                    int size10 = $this$fastForEach$iv5.size();
                                    for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                        Object item$iv5 = $this$fastForEach$iv5.get(index$iv5);
                                        Placeable it22 = (Placeable) item$iv5;
                                        int left = placement.getLeft();
                                        Intrinsics.checkNotNull(num2);
                                        Placeable.PlacementScope.place$default($this$layout, it22, left, i12 - num2.intValue(), 0.0f, 4, null);
                                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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
                    ScaffoldKt.m2427ScaffoldLayoutFMILGgc(fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
