package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float ContainerMaxWidth = Dp.m6693constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m6693constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m6693constructorimpl(16);
    private static final float HorizontalSpacingButtonSide = Dp.m6693constructorimpl(8);
    private static final float SeparateButtonExtraY = Dp.m6693constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m6693constructorimpl(6);
    private static final float TextEndExtraSpacing = Dp.m6693constructorimpl(8);
    private static final float LongButtonVerticalOffset = Dp.m6693constructorimpl(12);

    /* renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m2546SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionContentColor, long dismissActionContentColor, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function24;
        Function2 function25;
        boolean z;
        Shape shape2;
        long j;
        int $dirty;
        int i2;
        Modifier.Companion modifier3;
        Function2 action;
        Function2 dismissAction;
        boolean actionOnNewLine2;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        long actionContentColor2;
        long dismissActionContentColor2;
        int $dirty2;
        final Modifier modifier4;
        Composer $composer2;
        final Function2 action2;
        final Shape shape4;
        final boolean actionOnNewLine3;
        final long contentColor3;
        final long contentColor4;
        final Function2 dismissAction2;
        final long containerColor3;
        final long containerColor4;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation($composer3, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)107@5066L5,108@5118L5,109@5168L12,110@5231L18,111@5307L25,120@5574L1123,114@5378L1319:Snackbar.kt#uh7d8r");
        int $dirty4 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty4 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty4 |= 48;
            function24 = function2;
        } else if (($changed & 48) == 0) {
            function24 = function2;
            $dirty4 |= $composer3.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
            function25 = function22;
        } else if (($changed & 384) == 0) {
            function25 = function22;
            $dirty4 |= $composer3.changedInstance(function25) ? 256 : 128;
        } else {
            function25 = function22;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = actionOnNewLine;
        } else if (($changed & 3072) == 0) {
            z = actionOnNewLine;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i7 = $composer3.changed(shape2) ? 16384 : 8192;
                $dirty4 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i7;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                j = containerColor;
                int i8 = $composer3.changed(j) ? 131072 : 65536;
                $dirty4 |= i8;
            } else {
                j = containerColor;
            }
            $dirty4 |= i8;
        } else {
            j = containerColor;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                i2 = i3;
                int i9 = $composer3.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i9;
            } else {
                $dirty3 = $dirty4;
                i2 = i3;
            }
            $dirty = $dirty3 | i9;
        } else {
            $dirty = $dirty4;
            i2 = i3;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(actionContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(dismissActionContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            action2 = function24;
            dismissAction2 = function25;
            actionOnNewLine3 = z;
            shape4 = shape2;
            containerColor3 = j;
            contentColor3 = contentColor;
            containerColor4 = actionContentColor;
            contentColor4 = dismissActionContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                action = i4 != 0 ? null : function24;
                dismissAction = i5 != 0 ? null : function25;
                actionOnNewLine2 = i6 != 0 ? false : z;
                if ((i & 16) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty &= -57345;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    containerColor2 = SnackbarDefaults.INSTANCE.getColor($composer3, 6);
                    $dirty &= -458753;
                } else {
                    containerColor2 = j;
                }
                if ((i & 64) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer3, 6);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 128) != 0) {
                    actionContentColor2 = SnackbarDefaults.INSTANCE.getActionContentColor($composer3, 6);
                    $dirty &= -29360129;
                } else {
                    actionContentColor2 = actionContentColor;
                }
                if ((i & 256) != 0) {
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer3, 6);
                    $dirty2 = $dirty & (-234881025);
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty2 = $dirty & (-234881025);
                    modifier3 = modifier2;
                    action = function24;
                    dismissAction = function25;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = j;
                    contentColor2 = contentColor;
                } else {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier3 = modifier2;
                    action = function24;
                    dismissAction = function25;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = j;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1235788955, $dirty2, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:113)");
            }
            final Function2 action3 = action;
            final Function2 dismissAction3 = dismissAction;
            final boolean actionOnNewLine4 = actionOnNewLine2;
            final long actionContentColor3 = actionContentColor2;
            final long dismissActionContentColor3 = dismissActionContentColor2;
            Modifier modifier5 = modifier3;
            SurfaceKt.m2561SurfaceT9BRK9s(modifier5, shape3, containerColor2, contentColor2, 0.0f, SnackbarTokens.INSTANCE.m3519getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                    ComposerKt.sourceInformation($composer4, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1829663446, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                        }
                        TextStyle textStyle = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), $composer4, 6);
                        final TextStyle actionTextStyle = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), $composer4, 6);
                        ProvidedValue<TextStyle> providedValueProvides = TextKt.getLocalTextStyle().provides(textStyle);
                        final boolean z2 = actionOnNewLine4;
                        final Function2<Composer, Integer, Unit> function26 = action3;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final Function2<Composer, Integer, Unit> function28 = dismissAction3;
                        final long j2 = actionContentColor3;
                        final long j3 = dismissActionContentColor3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                ComposerKt.sourceInformation($composer5, "C:Snackbar.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(835891690, $changed3, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                    }
                                    if (z2 && function26 != null) {
                                        $composer5.startReplaceGroup(-810715387);
                                        ComposerKt.sourceInformation($composer5, "126@5873L383");
                                        SnackbarKt.m2544NewLineButtonSnackbarkKq0p4A(function27, function26, function28, actionTextStyle, j2, j3, $composer5, 0);
                                        $composer5.endReplaceGroup();
                                    } else {
                                        $composer5.startReplaceGroup(-810701708);
                                        ComposerKt.sourceInformation($composer5, "135@6301L366");
                                        SnackbarKt.m2545OneRowSnackbarkKq0p4A(function27, function26, function28, actionTextStyle, j2, j3, $composer5, 0);
                                        $composer5.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, ($dirty2 & 14) | 12779520 | (($dirty2 >> 9) & 112) | (($dirty2 >> 9) & 896) | (($dirty2 >> 9) & 7168), 80);
            modifier4 = modifier5;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            action2 = action3;
            shape4 = shape3;
            actionOnNewLine3 = actionOnNewLine4;
            contentColor3 = contentColor2;
            contentColor4 = dismissActionContentColor2;
            dismissAction2 = dismissAction;
            containerColor3 = containerColor2;
            containerColor4 = actionContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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
                    SnackbarKt.m2546SnackbareQBnUkQ(modifier4, action2, dismissAction2, actionOnNewLine3, shape4, containerColor3, contentColor3, containerColor4, contentColor4, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m2547SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionColor, long actionContentColor, long dismissActionContentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Shape shape2;
        long j;
        long j2;
        int $dirty;
        int i2;
        final Modifier.Companion modifier3;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        long actionColor2;
        long actionContentColor2;
        long dismissActionContentColor2;
        long contentColor3;
        final long actionColor3;
        long actionContentColor3;
        boolean actionOnNewLine2;
        Shape shape4;
        long containerColor3;
        Composer $composer2;
        final long actionColor4;
        final boolean actionOnNewLine3;
        final Shape shape5;
        final long containerColor4;
        final long contentColor4;
        final long actionContentColor4;
        final long dismissActionContentColor3;
        int $dirty2;
        Composer $composer3 = $composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation($composer3, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)205@9602L5,206@9654L5,207@9704L12,208@9760L11,209@9822L18,210@9898L25,251@11371L38,241@10959L456:Snackbar.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(snackbarData) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            z = actionOnNewLine;
        } else if (($changed & 384) == 0) {
            z = actionOnNewLine;
            $dirty3 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i5 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                j = containerColor;
                int i6 = $composer3.changed(j) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                j = containerColor;
            }
            $dirty3 |= i6;
        } else {
            j = containerColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                j2 = contentColor;
                int i7 = $composer3.changed(j2) ? 131072 : 65536;
                $dirty3 |= i7;
            } else {
                j2 = contentColor;
            }
            $dirty3 |= i7;
        } else {
            j2 = contentColor;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty2 = $dirty3;
                i2 = i3;
                int i8 = $composer3.changed(actionColor) ? 1048576 : 524288;
                $dirty = $dirty2 | i8;
            } else {
                $dirty2 = $dirty3;
                i2 = i3;
            }
            $dirty = $dirty2 | i8;
        } else {
            $dirty = $dirty3;
            i2 = i3;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(actionContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(dismissActionContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            actionOnNewLine3 = z;
            shape5 = shape2;
            containerColor4 = j;
            contentColor4 = j2;
            actionColor4 = actionColor;
            actionContentColor4 = actionContentColor;
            dismissActionContentColor3 = dismissActionContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean actionOnNewLine4 = i4 != 0 ? false : z;
                if ((i & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    containerColor2 = SnackbarDefaults.INSTANCE.getColor($composer3, 6);
                    $dirty &= -57345;
                } else {
                    containerColor2 = j;
                }
                if ((i & 32) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer3, 6);
                    $dirty &= -458753;
                } else {
                    contentColor2 = j2;
                }
                if ((i & 64) != 0) {
                    actionColor2 = SnackbarDefaults.INSTANCE.getActionColor($composer3, 6);
                    $dirty &= -3670017;
                } else {
                    actionColor2 = actionColor;
                }
                if ((i & 128) != 0) {
                    actionContentColor2 = SnackbarDefaults.INSTANCE.getActionContentColor($composer3, 6);
                    $dirty &= -29360129;
                } else {
                    actionContentColor2 = actionContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty = (-234881025) & $dirty;
                    actionColor3 = actionColor2;
                    actionContentColor3 = actionContentColor2;
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer3, 6);
                    actionOnNewLine2 = actionOnNewLine4;
                    shape4 = shape3;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                    contentColor3 = contentColor2;
                    actionColor3 = actionColor2;
                    actionContentColor3 = actionContentColor2;
                    actionOnNewLine2 = actionOnNewLine4;
                    shape4 = shape3;
                    containerColor3 = containerColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    actionColor3 = actionColor;
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty &= -234881025;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape4 = shape2;
                    containerColor3 = j;
                    contentColor3 = j2;
                } else {
                    actionColor3 = actionColor;
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape4 = shape2;
                    containerColor3 = j;
                    contentColor3 = j2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, $dirty, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:211)");
            }
            final String actionLabel = snackbarData.getVisuals().getActionLabel();
            $composer3.startReplaceGroup(1561344786);
            ComposerKt.sourceInformation($composer3, "215@10097L267");
            Function2 actionComposable = actionLabel != null ? ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C217@10171L44,218@10247L32,219@10311L21,216@10115L235:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1378313599, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:216)");
                        }
                        ButtonColors buttonColorsM1838textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1838textButtonColorsro_MJ88(0L, actionColor3, 0L, 0L, $composer4, 24576, 13);
                        ComposerKt.sourceInformationMarkerStart($composer4, 642119911, "CC(remember):Snackbar.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(snackbarData);
                        final SnackbarData snackbarData2 = snackbarData;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
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
                                    snackbarData2.performAction();
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final String str = actionLabel;
                        ButtonKt.TextButton((Function0) value$iv, null, false, null, buttonColorsM1838textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope $this$TextButton, Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C219@10313L17:Snackbar.kt#uh7d8r");
                                if (($changed3 & 17) == 16 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(521110564, $changed3, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:219)");
                                }
                                TextKt.m2711Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54) : null;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1561358724);
            ComposerKt.sourceInformation($composer3, "227@10548L362");
            Function2 dismissActionComposable = snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C229@10608L26,228@10566L330:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1812633777, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:228)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 642131457, "CC(remember):Snackbar.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(snackbarData);
                        final SnackbarData snackbarData2 = snackbarData;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                    snackbarData2.dismiss();
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2000getLambda1$material3_release(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54) : null;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            m2546SnackbareQBnUkQ(PaddingKt.m681padding3ABfNKs(modifier3, Dp.m6693constructorimpl(12)), actionComposable, dismissActionComposable, actionOnNewLine2, shape4, containerColor3, contentColor3, actionContentColor3, dismissActionContentColor2, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C251@11373L34:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                    }
                    TextKt.m2711Text4IGK_g(snackbarData.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer2, (($dirty << 3) & 7168) | 805306368 | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (3670016 & ($dirty << 3)) | (29360128 & $dirty) | (234881024 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor4 = actionColor3;
            actionOnNewLine3 = actionOnNewLine2;
            shape5 = shape4;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
            actionContentColor4 = actionContentColor3;
            dismissActionContentColor3 = dismissActionContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    SnackbarKt.m2547SnackbarsDKtq54(snackbarData, modifier3, actionOnNewLine3, shape5, containerColor4, contentColor4, actionColor4, actionContentColor4, dismissActionContentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x05f9  */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2544NewLineButtonSnackbarkKq0p4A(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, final androidx.compose.ui.text.TextStyle r76, final long r77, final long r79, androidx.compose.runtime.Composer r81, final int r82) {
        /*
            Method dump skipped, instructions count: 1557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2544NewLineButtonSnackbarkKq0p4A(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, long, long, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2545OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle actionTextStyle, final long actionTextColor, final long dismissActionColor, Composer $composer, final int $changed) {
        Function0 factory$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int $changed$iv;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)338@14229L3580,312@13223L4586:Snackbar.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(actionTextStyle) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(actionTextColor) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(dismissActionColor) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, $dirty2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
            }
            final String textTag = "text";
            final String actionTag = "action";
            final String dismissActionTag = "dismissAction";
            Modifier modifier$iv = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, function23 == null ? HorizontalSpacingButtonSide : Dp.m6693constructorimpl(0), 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1386942712, "CC(remember):Snackbar.kt#9igjgp");
            MeasurePolicy value$iv = $composer3.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo34measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Object it$iv;
                        Object it$iv2;
                        final int actionButtonPlaceY;
                        int minContainerHeight;
                        final int textPlaceY;
                        int it;
                        MeasureScope measureScope = $this$Layout;
                        long j = constraints;
                        int containerWidth = Math.min(Constraints.m6636getMaxWidthimpl(j), measureScope.mo361roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
                        String str = actionTag;
                        int index$iv$iv = 0;
                        int size = list.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                                it$iv = null;
                                break;
                            }
                            it$iv = list.get(index$iv$iv);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) it$iv), str)) {
                                break;
                            }
                            index$iv$iv++;
                        }
                        Measurable measurable = (Measurable) it$iv;
                        final Placeable actionButtonPlaceable = measurable != null ? measurable.mo5535measureBRTryo0(j) : null;
                        String str2 = dismissActionTag;
                        List $this$fastFirstOrNull$iv = list;
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastFirstOrNull$iv.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                                it$iv2 = null;
                                break;
                            }
                            it$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                            List $this$fastFirstOrNull$iv2 = $this$fastFirstOrNull$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) it$iv2), str2)) {
                                break;
                            }
                            index$iv$iv2++;
                            $this$fastFirstOrNull$iv = $this$fastFirstOrNull$iv2;
                        }
                        Measurable measurable2 = (Measurable) it$iv2;
                        final Placeable dismissButtonPlaceable = measurable2 != null ? measurable2.mo5535measureBRTryo0(j) : null;
                        int actionButtonWidth = actionButtonPlaceable != null ? actionButtonPlaceable.getWidth() : 0;
                        int actionButtonHeight = actionButtonPlaceable != null ? actionButtonPlaceable.getHeight() : 0;
                        int dismissButtonWidth = dismissButtonPlaceable != null ? dismissButtonPlaceable.getWidth() : 0;
                        int dismissButtonHeight = dismissButtonPlaceable != null ? dismissButtonPlaceable.getHeight() : 0;
                        int extraSpacingWidth = dismissButtonWidth == 0 ? measureScope.mo361roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0;
                        int textMaxWidth = RangesKt.coerceAtLeast(((containerWidth - actionButtonWidth) - dismissButtonWidth) - extraSpacingWidth, Constraints.m6638getMinWidthimpl(j));
                        String str3 = textTag;
                        int size3 = list.size();
                        int index$iv$iv3 = 0;
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv = list.get(index$iv$iv3);
                            int index$iv$iv4 = index$iv$iv3;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) item$iv$iv), str3)) {
                                int dismissButtonHeight2 = dismissButtonHeight;
                                final Placeable textPlaceable = ((Measurable) item$iv$iv).mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(j) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(j) : textMaxWidth, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(j) : 0));
                                int firstTextBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                int lastTextBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
                                boolean z = true;
                                boolean hasText = (firstTextBaseline == Integer.MIN_VALUE || lastTextBaseline == Integer.MIN_VALUE) ? false : true;
                                if (firstTextBaseline != lastTextBaseline && hasText) {
                                    z = false;
                                }
                                boolean isOneLine = z;
                                final int dismissButtonPlaceX = containerWidth - dismissButtonWidth;
                                final int actionButtonPlaceX = dismissButtonPlaceX - actionButtonWidth;
                                if (isOneLine) {
                                    int minContainerHeight2 = measureScope.mo361roundToPx0680j_4(SnackbarTokens.INSTANCE.m3521getSingleLineContainerHeightD9Ej5fM());
                                    int contentHeight = Math.max(actionButtonHeight, dismissButtonHeight2);
                                    int containerHeight = Math.max(minContainerHeight2, contentHeight);
                                    int textPlaceY2 = (containerHeight - textPlaceable.getHeight()) / 2;
                                    int i = (actionButtonPlaceable == null || (it = actionButtonPlaceable.get(AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) ? 0 : (textPlaceY2 + firstTextBaseline) - it;
                                    actionButtonPlaceY = i;
                                    minContainerHeight = containerHeight;
                                    textPlaceY = textPlaceY2;
                                } else {
                                    int baselineOffset = measureScope.mo361roundToPx0680j_4(SnackbarKt.HeightToFirstLine);
                                    int textPlaceY3 = baselineOffset - firstTextBaseline;
                                    int minContainerHeight3 = measureScope.mo361roundToPx0680j_4(SnackbarTokens.INSTANCE.m3522getTwoLinesContainerHeightD9Ej5fM());
                                    int contentHeight2 = textPlaceY3 + textPlaceable.getHeight();
                                    int containerHeight2 = Math.max(minContainerHeight3, contentHeight2);
                                    actionButtonPlaceY = actionButtonPlaceable != null ? (containerHeight2 - actionButtonPlaceable.getHeight()) / 2 : 0;
                                    minContainerHeight = containerHeight2;
                                    textPlaceY = textPlaceY3;
                                }
                                final int dismissButtonPlaceY = dismissButtonPlaceable != null ? (minContainerHeight - dismissButtonPlaceable.getHeight()) / 2 : 0;
                                return MeasureScope.CC.layout$default(measureScope, containerWidth, minContainerHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        Placeable.PlacementScope.placeRelative$default($this$layout, textPlaceable, 0, textPlaceY, 0.0f, 4, null);
                                        Placeable placeable = dismissButtonPlaceable;
                                        if (placeable != null) {
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, dismissButtonPlaceX, dismissButtonPlaceY, 0.0f, 4, null);
                                        }
                                        Placeable placeable2 = actionButtonPlaceable;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, actionButtonPlaceX, actionButtonPlaceY, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                            index$iv$iv3 = index$iv$iv4 + 1;
                            measureScope = $this$Layout;
                            j = constraints;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((384 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer3.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3678constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2016566027, "C314@13253L86:Snackbar.kt#uh7d8r");
            Modifier modifier$iv2 = PaddingKt.m683paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1308937155, "C314@13331L6:Snackbar.kt#uh7d8r");
            function2.invoke($composer2, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-904778058);
            ComposerKt.sourceInformation($composer2, "316@13390L295");
            if (function22 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                }
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1309057900, "C317@13446L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(actionTextColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function22, $composer2, ProvidedValue.$stable | ($dirty2 & 112));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-904766579);
            ComposerKt.sourceInformation($composer2, "325@13757L247");
            if (function23 != null) {
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    $changed$iv = 6;
                } else {
                    $changed$iv = 6;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    int i7 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1309427203, "C326@13820L166:Snackbar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(dismissActionColor)), function23, $composer2, ProvidedValue.$stable | (($dirty2 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i62 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                int i72 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1309427203, "C326@13820L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(dismissActionColor)), function23, $composer2, ProvidedValue.$stable | (($dirty2 >> 3) & 112));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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

                public final void invoke(Composer composer, int i8) {
                    SnackbarKt.m2545OneRowSnackbarkKq0p4A(function2, function22, function23, actionTextStyle, actionTextColor, dismissActionColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
