package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0094\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0086\u0001\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0001\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0094\u0001\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001c\u001a\u0080\u0001\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u001f\u001a\u0090\u0001\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001an\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a~\u00107\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00106\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6693constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2610PrimaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation($composer3, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)154@7555L21,155@7619L19,156@7698L189,165@8005L76:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.rememberComposableLambda(-2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C157@7723L158:TabRow.kt#uh7d8r");
                            int $dirty2 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty2 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                            }
                            int $dirty3 = $dirty2;
                            if (($dirty3 & 19) != 18 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2021049253, $dirty3, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:157)");
                                }
                                TabRowDefaults.INSTANCE.m2605PrimaryIndicator10LGxhE($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, true), Dp.INSTANCE.m6713getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, $composer4, 196656, 28);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54);
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2001getLambda1$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:164)");
            }
            $composer2 = $composer3;
            m2617TabRowImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
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
                    TabRowKt.m2610PrimaryTabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2615SecondaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation($composer3, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)208@10501L23,209@10567L21,211@10668L160,219@10946L76:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.rememberComposableLambda(286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C212@10697L121:TabRow.kt#uh7d8r");
                            int $dirty2 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty2 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                            }
                            if (($dirty2 & 19) != 18 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(286693261, $dirty2, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:212)");
                                }
                                TabRowDefaults.INSTANCE.m2606SecondaryIndicator9IZ8Weo($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, false), 0.0f, 0L, $composer4, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54);
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2002getLambda2$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)");
            }
            $composer2 = $composer3;
            m2617TabRowImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
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
                    TabRowKt.m2615SecondaryTabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2616TabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation($composer3, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)302@15283L21,303@15347L19,305@15459L246,315@15823L90:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.rememberComposableLambda(-2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C307@15564L117:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2052073983, $changed2, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:306)");
                            }
                            if (selectedTabIndex < list.size()) {
                                TabRowDefaults.INSTANCE.m2606SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2003getLambda3$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.TabRow (TabRow.kt:314)");
            }
            $composer2 = $composer3;
            m2618TabRowWithSubcomposeImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                    TabRowKt.m2616TabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2609PrimaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int i2;
        int $dirty;
        long containerColor3;
        float edgePadding3;
        ScrollState scrollState3;
        Function2 divider;
        Function3 indicator;
        Modifier modifier3;
        long contentColor3;
        Composer $composer2;
        final Function2 divider2;
        final Function3 indicator2;
        final float edgePadding4;
        final Modifier modifier4;
        final ScrollState scrollState4;
        final long contentColor4;
        final long contentColor5;
        Composer $composer3 = $composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation($composer3, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)357@18289L21,358@18355L21,359@18419L19,362@18589L198,371@18905L328:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer3.changed(scrollState2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i4;
        } else {
            scrollState2 = scrollState;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier4 = modifier2;
            scrollState4 = scrollState2;
            contentColor5 = containerColor2;
            contentColor4 = contentColor2;
            $composer2 = $composer3;
            edgePadding4 = edgePadding2;
            indicator2 = function3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2607getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                Function3 indicator3 = i8 != 0 ? ComposableLambdaKt.rememberComposableLambda(1601820568, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                        invoke(tabIndicatorScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C363@18618L159:TabRow.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 6) == 0) {
                            $dirty3 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                        }
                        int $dirty4 = $dirty3;
                        if (($dirty4 & 19) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1601820568, $dirty4, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:363)");
                            }
                            TabRowDefaults.INSTANCE.m2605PrimaryIndicator10LGxhE($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, true), Dp.INSTANCE.m6713getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, $composer4, 196656, 28);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54) : function3;
                if (i2 != 0) {
                    $dirty = $dirty2;
                    long j = contentColor2;
                    indicator = indicator3;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2004getLambda4$material3_release();
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = j;
                } else {
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    long j2 = contentColor2;
                    divider = function2;
                    indicator = indicator3;
                    modifier3 = modifier2;
                    contentColor3 = j2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = contentColor2;
                    indicator = function3;
                    divider = function2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = contentColor2;
                    indicator = function3;
                    divider = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1763241113, $dirty, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:370)");
            }
            m2612ScrollableTabRowImplsKfQg0A(selectedTabIndex, modifier3, containerColor3, contentColor3, edgePadding3, scrollState3, indicator, divider, function22, $composer3, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (57344 & ($dirty >> 3)) | (($dirty << 9) & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            divider2 = divider;
            indicator2 = indicator;
            edgePadding4 = edgePadding3;
            long j3 = containerColor3;
            modifier4 = modifier3;
            scrollState4 = scrollState3;
            contentColor4 = contentColor3;
            contentColor5 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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
                    TabRowKt.m2609PrimaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier4, scrollState4, contentColor5, contentColor4, edgePadding4, indicator2, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2614SecondaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int i2;
        int $dirty;
        long containerColor3;
        float edgePadding3;
        ScrollState scrollState3;
        Function2 divider;
        Function3 indicator;
        Modifier modifier3;
        long contentColor3;
        Composer $composer2;
        final Function2 divider2;
        final Function3 indicator2;
        final float edgePadding4;
        final Modifier modifier4;
        final ScrollState scrollState4;
        final long contentColor4;
        final long contentColor5;
        Composer $composer3 = $composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation($composer3, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)427@21884L21,428@21950L23,429@22016L21,432@22188L160,440@22466L327:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer3.changed(scrollState2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i4;
        } else {
            scrollState2 = scrollState;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier4 = modifier2;
            scrollState4 = scrollState2;
            contentColor5 = containerColor2;
            contentColor4 = contentColor2;
            $composer2 = $composer3;
            edgePadding4 = edgePadding2;
            indicator2 = function3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2607getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                Function3 indicator3 = i8 != 0 ? ComposableLambdaKt.rememberComposableLambda(1535842470, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                        invoke(tabIndicatorScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C433@22217L121:TabRow.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 6) == 0) {
                            $dirty3 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                        }
                        if (($dirty3 & 19) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1535842470, $dirty3, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:433)");
                            }
                            TabRowDefaults.INSTANCE.m2606SecondaryIndicator9IZ8Weo($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, false), 0.0f, 0L, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54) : function3;
                if (i2 != 0) {
                    $dirty = $dirty2;
                    long j = contentColor2;
                    indicator = indicator3;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2005getLambda5$material3_release();
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = j;
                } else {
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    long j2 = contentColor2;
                    divider = function2;
                    indicator = indicator3;
                    modifier3 = modifier2;
                    contentColor3 = j2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = contentColor2;
                    indicator = function3;
                    divider = function2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    scrollState3 = scrollState2;
                    contentColor3 = contentColor2;
                    indicator = function3;
                    divider = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1821940917, $dirty, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:439)");
            }
            m2612ScrollableTabRowImplsKfQg0A(selectedTabIndex, modifier3, containerColor3, contentColor3, edgePadding3, scrollState3, indicator, divider, function22, $composer3, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (57344 & ($dirty >> 3)) | (($dirty << 9) & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            divider2 = divider;
            indicator2 = indicator;
            edgePadding4 = edgePadding3;
            long j3 = containerColor3;
            modifier4 = modifier3;
            scrollState4 = scrollState3;
            contentColor4 = contentColor3;
            contentColor5 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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
                    TabRowKt.m2614SecondaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier4, scrollState4, contentColor5, contentColor4, edgePadding4, indicator2, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m2611ScrollableTabRowsKfQg0A(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        Function3 indicator;
        int $dirty;
        final Modifier modifier3;
        final long containerColor3;
        final long contentColor3;
        final float edgePadding3;
        Function3 indicator2;
        Function2 divider;
        Composer $composer2;
        final Function2 divider2;
        final Function3 indicator3;
        Composer $composer3 = $composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)495@25349L21,496@25413L19,499@25596L164,516@26202L21,507@25878L351:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            edgePadding2 = edgePadding;
        } else if (($changed & 24576) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            indicator = function3;
        } else if ((196608 & $changed) == 0) {
            indicator = function3;
            $dirty2 |= $composer3.changedInstance(indicator) ? 131072 : 65536;
        } else {
            indicator = function3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier3 = modifier2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
            indicator3 = indicator;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if (i5 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2607getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.rememberComposableLambda(-913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C500@25641L109:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-913748678, $changed2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:500)");
                            }
                            TabRowDefaults.INSTANCE.m2606SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2006getLambda6$material3_release();
                    indicator2 = indicator;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, $dirty, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:506)");
            }
            m2613ScrollableTabRowWithSubcomposeImplqhFBPw4(selectedTabIndex, indicator2, modifier3, containerColor3, contentColor3, edgePadding3, divider, function22, ScrollKt.rememberScrollState(0, $composer3, 0, 1), $composer3, ($dirty & 14) | (($dirty >> 12) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (3670016 & $dirty) | (29360128 & $dirty), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            divider2 = divider;
            indicator3 = indicator2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                    TabRowKt.m2611ScrollableTabRowsKfQg0A(selectedTabIndex, modifier3, containerColor3, contentColor3, edgePadding3, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m2617TabRowImplDTcfvLk(Modifier modifier, final long containerColor, final long contentColor, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Modifier modifier2;
        long j;
        long j2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation($composer3, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)575@27973L4041,571@27843L4171:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            j = containerColor;
            $dirty |= $composer3.changed(j) ? 32 : 16;
        } else {
            j = containerColor;
        }
        if (($changed & 384) == 0) {
            j2 = contentColor;
            $dirty |= $composer3.changed(j2) ? 256 : 128;
        } else {
            j2 = contentColor;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & $dirty) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, $dirty, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:570)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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
                    Object value$iv;
                    MultiContentMeasurePolicy value$iv2;
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C576@27995L1274,617@29457L21,619@29508L2500,611@29279L2729:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, $changed2, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:576)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 1811397697, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv = $composer4.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new TabRowKt$TabRowImpl$1$scope$1$1();
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 scope = (TabRowKt$TabRowImpl$1$scope$1$1) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        boolean invalid$iv$iv = true;
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.rememberComposableLambda(1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
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
                                ComposerKt.sourceInformation($composer5, "C617@29465L11:TabRow.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, $changed3, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:617)");
                                }
                                function32.invoke(scope, $composer5, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54)});
                        ComposerKt.sourceInformationMarkerStart($composer4, 1811447339, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
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
                                    List tabMeasurables = list.get(0);
                                    List dividerMeasurables = list.get(1);
                                    List indicatorMeasurables = list.get(2);
                                    int tabRowWidth = Constraints.m6636getMaxWidthimpl(constraints);
                                    int tabCount = tabMeasurables.size();
                                    final Ref.IntRef tabWidth = new Ref.IntRef();
                                    if (tabCount > 0) {
                                        tabWidth.element = tabRowWidth / tabCount;
                                    }
                                    Object initial$iv = 0;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = tabMeasurables.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                        Measurable curr = (Measurable) item$iv$iv;
                                        int tabRowWidth2 = tabRowWidth;
                                        int max = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                        index$iv$iv++;
                                        tabRowWidth = tabRowWidth2;
                                        initial$iv = initial$iv;
                                    }
                                    int tabRowWidth3 = tabRowWidth;
                                    int tabRowHeight = ((Number) accumulator$iv).intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = scope;
                                    ArrayList arrayList = new ArrayList(tabCount);
                                    int i = 0;
                                    while (i < tabCount) {
                                        int index = i;
                                        float contentWidth = $this$Layout.mo364toDpu2uoSUM(Math.min(tabMeasurables.get(index).maxIntrinsicWidth(tabRowHeight), tabWidth.element));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        int tabRowHeight2 = tabRowHeight;
                                        float other$iv = Dp.m6693constructorimpl(2 * arg0$iv);
                                        Dp dpM6691boximpl = Dp.m6691boximpl(Dp.m6693constructorimpl(contentWidth - other$iv));
                                        float contentWidth2 = 24;
                                        float indicatorWidth = ((Dp) ComparisonsKt.maxOf(dpM6691boximpl, Dp.m6691boximpl(Dp.m6693constructorimpl(contentWidth2)))).m6707unboximpl();
                                        float arg0$iv2 = $this$Layout.mo364toDpu2uoSUM(tabWidth.element);
                                        arrayList.add(new TabPosition(Dp.m6693constructorimpl(index * arg0$iv2), $this$Layout.mo364toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                        i++;
                                        tabRowHeight = tabRowHeight2;
                                    }
                                    int tabRowHeight3 = tabRowHeight;
                                    tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
                                    List target$iv = new ArrayList(tabMeasurables.size());
                                    List $this$fastForEach$iv$iv = tabMeasurables;
                                    int tabRowHeight4 = 0;
                                    int size2 = $this$fastForEach$iv$iv.size();
                                    while (tabRowHeight4 < size2) {
                                        Object item$iv$iv2 = $this$fastForEach$iv$iv.get(tabRowHeight4);
                                        Measurable it = (Measurable) item$iv$iv2;
                                        int index$iv$iv2 = tabRowHeight4;
                                        int tabRowHeight5 = tabRowHeight3;
                                        target$iv.add(it.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, tabWidth.element, tabWidth.element, tabRowHeight5, tabRowHeight3)));
                                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                        size2 = size2;
                                        tabMeasurables = tabMeasurables;
                                        tabRowHeight3 = tabRowHeight5;
                                        tabRowHeight4 = index$iv$iv2 + 1;
                                    }
                                    int tabRowHeight6 = tabRowHeight3;
                                    final List tabPlaceables = target$iv;
                                    List $this$fastMap$iv = dividerMeasurables;
                                    int $i$f$fastMap = 0;
                                    ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
                                    int index$iv$iv3 = 0;
                                    int size3 = $this$fastMap$iv.size();
                                    while (index$iv$iv3 < size3) {
                                        Object item$iv$iv3 = $this$fastMap$iv.get(index$iv$iv3);
                                        int $i$f$fastMap2 = $i$f$fastMap;
                                        Measurable it2 = (Measurable) item$iv$iv3;
                                        target$iv2.add(it2.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0)));
                                        index$iv$iv3++;
                                        $this$fastMap$iv = $this$fastMap$iv;
                                        $i$f$fastMap = $i$f$fastMap2;
                                        tabRowHeight6 = tabRowHeight6;
                                        target$iv2 = target$iv2;
                                    }
                                    int tabRowHeight7 = tabRowHeight6;
                                    final ArrayList dividerPlaceables = target$iv2;
                                    List $this$fastMap$iv2 = indicatorMeasurables;
                                    int $i$f$fastMap3 = 0;
                                    List target$iv3 = new ArrayList($this$fastMap$iv2.size());
                                    List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
                                    int tabRowHeight8 = 0;
                                    int size4 = $this$fastForEach$iv$iv2.size();
                                    while (tabRowHeight8 < size4) {
                                        Object item$iv$iv4 = $this$fastForEach$iv$iv2.get(tabRowHeight8);
                                        Measurable it3 = (Measurable) item$iv$iv4;
                                        int index$iv$iv4 = tabRowHeight8;
                                        int tabRowHeight9 = tabRowHeight7;
                                        target$iv3.add(it3.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, tabWidth.element, tabWidth.element, 0, tabRowHeight9)));
                                        $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                                        size4 = size4;
                                        $i$f$fastMap3 = $i$f$fastMap3;
                                        tabRowHeight7 = tabRowHeight9;
                                        tabRowHeight8 = index$iv$iv4 + 1;
                                        $this$fastMap$iv2 = $this$fastMap$iv2;
                                    }
                                    final int index$iv$iv5 = tabRowHeight7;
                                    final List indicatorPlaceables = target$iv3;
                                    return MeasureScope.CC.layout$default($this$Layout, tabRowWidth3, index$iv$iv5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
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
                                            List $this$fastForEachIndexed$iv = tabPlaceables;
                                            Ref.IntRef intRef = tabWidth;
                                            int size5 = $this$fastForEachIndexed$iv.size();
                                            for (int index$iv = 0; index$iv < size5; index$iv++) {
                                                Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                                int index2 = index$iv;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                            }
                                            List $this$fastForEachIndexed$iv2 = dividerPlaceables;
                                            int i2 = index$iv$iv5;
                                            int size6 = $this$fastForEachIndexed$iv2.size();
                                            for (int index$iv2 = 0; index$iv2 < size6; index$iv2++) {
                                                Object item$iv2 = $this$fastForEachIndexed$iv2.get(index$iv2);
                                                Placeable placeable = (Placeable) item$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List $this$fastForEach$iv = indicatorPlaceables;
                                            int i3 = index$iv$iv5;
                                            int size7 = $this$fastForEach$iv.size();
                                            for (int index$iv3 = 0; index$iv3 < size7; index$iv3++) {
                                                Object item$iv3 = $this$fastForEach$iv.get(index$iv3);
                                                Placeable it4 = (Placeable) item$iv3;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it4, 0, i3 - it4.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(listListOf);
                        ComposerKt.sourceInformationMarkerStart($composer4, -290761997, "CC(remember):Layout.kt#9igjgp");
                        if ((((432 & 896) ^ 384) <= 256 || !$composer4.changed(multiContentMeasurePolicy)) && (432 & 384) != 256) {
                            invalid$iv$iv = false;
                        }
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int $changed$iv$iv = 432 & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifierFillMaxWidth$default);
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        content$iv$iv.invoke($composer4, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
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
            }, $composer3, 54), $composer2, (($dirty << 3) & 896) | 12582912 | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
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
                    TabRowKt.m2617TabRowImplDTcfvLk(modifier3, containerColor, contentColor, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScrollableTabRowImpl-sKfQg0A, reason: not valid java name */
    public static final void m2612ScrollableTabRowImplsKfQg0A(final int selectedTabIndex, final Modifier modifier, final long containerColor, final long contentColor, final float edgePadding, final ScrollState scrollState, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        long j;
        float f;
        ScrollState scrollState2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1594140035);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRowImpl)P(7,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,6,4)709@32727L5081,699@32393L5415:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(containerColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            j = contentColor;
            $dirty |= $composer3.changed(j) ? 2048 : 1024;
        } else {
            j = contentColor;
        }
        if (($changed & 24576) == 0) {
            f = edgePadding;
            $dirty |= $composer3.changed(f) ? 16384 : 8192;
        } else {
            f = edgePadding;
        }
        if ((196608 & $changed) == 0) {
            scrollState2 = scrollState;
            $dirty |= $composer3.changed(scrollState2) ? 131072 : 65536;
        } else {
            scrollState2 = scrollState;
        }
        if ((1572864 & $changed) == 0) {
            function32 = function3;
            $dirty |= $composer3.changedInstance(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594140035, $dirty, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:698)");
            }
            final float f2 = f;
            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState2, false, null, false, 14, null))), null, containerColor, j, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1556158104, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
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
                    Object value$iv$iv;
                    Object value$iv;
                    Object value$iv2;
                    int i;
                    MultiContentMeasurePolicy value$iv3;
                    Object value$iv$iv2;
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C710@32758L24,712@32827L147,716@32996L1274,756@34410L21,758@34461L3341,751@34280L3522:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1556158104, $changed2, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:710)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer4, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, 413417697, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(scrollState) | $composer4.changed(coroutineScope);
                        ScrollState scrollState3 = scrollState;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new ScrollableTabData(scrollState3, coroutineScope);
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, 413424232, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1();
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 scope = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function34 = function33;
                        List contents$iv = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.rememberComposableLambda(-1530560661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1.1
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
                                ComposerKt.sourceInformation($composer5, "C756@34418L11:TabRow.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1530560661, $changed3, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous> (TabRow.kt:756)");
                                }
                                function34.invoke(scope, $composer5, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54)});
                        ComposerKt.sourceInformationMarkerStart($composer4, 413473179, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(f2) | $composer4.changed(selectedTabIndex) | $composer4.changedInstance(scrollableTabData);
                        final float f3 = f2;
                        final int i2 = selectedTabIndex;
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            i = 0;
                            value$iv3 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                                    return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                                }

                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                                    return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                                }

                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                                    return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                                }

                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                                    return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                                }

                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo629measure3p2s80s(final MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                                    MeasureScope measureScope = $this$Layout;
                                    List tabMeasurables = list.get(0);
                                    List dividerMeasurables = list.get(1);
                                    List indicatorMeasurables = list.get(2);
                                    final int padding = measureScope.mo361roundToPx0680j_4(f3);
                                    int tabCount = tabMeasurables.size();
                                    int minTabWidth = measureScope.mo361roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    Object initial$iv = 0;
                                    List $this$fastFold$iv = tabMeasurables;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = $this$fastFold$iv.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = $this$fastFold$iv.get(index$iv$iv);
                                        Measurable measurable = (Measurable) item$iv$iv;
                                        Object initial$iv2 = initial$iv;
                                        int curr = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr, measurable.maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        index$iv$iv++;
                                        initial$iv = initial$iv2;
                                        $this$fastFold$iv = $this$fastFold$iv;
                                    }
                                    final int layoutHeight = ((Number) accumulator$iv).intValue();
                                    int layoutWidth = padding * 2;
                                    long tabConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : minTabWidth, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : layoutHeight, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : layoutHeight);
                                    Ref.FloatRef left = new Ref.FloatRef();
                                    left.element = f3;
                                    List target$iv = new ArrayList(tabMeasurables.size());
                                    int index$iv$iv2 = 0;
                                    for (int layoutWidth2 = tabMeasurables.size(); index$iv$iv2 < layoutWidth2; layoutWidth2 = layoutWidth2) {
                                        Object item$iv$iv2 = tabMeasurables.get(index$iv$iv2);
                                        int index$iv$iv3 = index$iv$iv2;
                                        Measurable it = (Measurable) item$iv$iv2;
                                        target$iv.add(it.mo5535measureBRTryo0(tabConstraints));
                                        index$iv$iv2 = index$iv$iv3 + 1;
                                    }
                                    List tabPlaceables = target$iv;
                                    ArrayList arrayList = new ArrayList(tabCount);
                                    int layoutWidth3 = layoutWidth;
                                    int i3 = 0;
                                    while (i3 < tabCount) {
                                        int index = i3;
                                        int tabCount2 = tabCount;
                                        List tabPlaceables2 = tabPlaceables;
                                        float tabWidth = ((Dp) ComparisonsKt.maxOf(Dp.m6691boximpl(TabRowKt.ScrollableTabRowMinimumTabWidth), Dp.m6691boximpl(measureScope.mo364toDpu2uoSUM(((Placeable) tabPlaceables.get(index)).getWidth())))).m6707unboximpl();
                                        layoutWidth3 += measureScope.mo361roundToPx0680j_4(tabWidth);
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        int i4 = i3;
                                        float other$iv = Dp.m6693constructorimpl(2 * arg0$iv);
                                        float contentWidth = ((Dp) ComparisonsKt.maxOf(Dp.m6691boximpl(Dp.m6693constructorimpl(tabWidth - other$iv)), Dp.m6691boximpl(Dp.m6693constructorimpl(24)))).m6707unboximpl();
                                        TabPosition tabPosition = new TabPosition(left.element, tabWidth, contentWidth, null);
                                        float arg0$iv2 = left.element;
                                        left.element = Dp.m6693constructorimpl(arg0$iv2 + tabWidth);
                                        arrayList.add(tabPosition);
                                        i3 = i4 + 1;
                                        tabCount = tabCount2;
                                        tabPlaceables = tabPlaceables2;
                                    }
                                    final List tabPlaceables3 = tabPlaceables;
                                    List positions = arrayList;
                                    scope.setTabPositions(positions);
                                    int $i$f$fastMap = 0;
                                    ArrayList target$iv2 = new ArrayList(dividerMeasurables.size());
                                    int size2 = dividerMeasurables.size();
                                    Ref.FloatRef left2 = left;
                                    int index$iv$iv4 = 0;
                                    while (index$iv$iv4 < size2) {
                                        Object item$iv$iv3 = dividerMeasurables.get(index$iv$iv4);
                                        int index$iv$iv5 = index$iv$iv4;
                                        Measurable it2 = (Measurable) item$iv$iv3;
                                        target$iv2.add(it2.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : layoutWidth3, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : layoutWidth3, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0)));
                                        index$iv$iv4 = index$iv$iv5 + 1;
                                        size2 = size2;
                                        $i$f$fastMap = $i$f$fastMap;
                                        target$iv2 = target$iv2;
                                    }
                                    final ArrayList dividerPlaceables = target$iv2;
                                    int layoutHeight2 = i2;
                                    List target$iv3 = new ArrayList(indicatorMeasurables.size());
                                    List $this$fastForEach$iv$iv = indicatorMeasurables;
                                    int index$iv$iv6 = 0;
                                    int size3 = $this$fastForEach$iv$iv.size();
                                    while (index$iv$iv6 < size3) {
                                        Object item$iv$iv4 = $this$fastForEach$iv$iv.get(index$iv$iv6);
                                        Measurable it3 = (Measurable) item$iv$iv4;
                                        int index$iv$iv7 = size3;
                                        int layoutHeight3 = layoutHeight;
                                        target$iv3.add(it3.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, 0, measureScope.mo361roundToPx0680j_4(((TabPosition) positions.get(layoutHeight2)).getWidth()), 0, layoutHeight3)));
                                        index$iv$iv6++;
                                        layoutHeight = layoutHeight3;
                                        layoutHeight2 = layoutHeight2;
                                        measureScope = $this$Layout;
                                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                        size3 = index$iv$iv7;
                                        positions = positions;
                                        left2 = left2;
                                    }
                                    final List positions2 = positions;
                                    final Ref.FloatRef left3 = left2;
                                    final List indicatorPlaceables = target$iv3;
                                    final float f4 = f3;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i5 = i2;
                                    return MeasureScope.CC.layout$default($this$Layout, layoutWidth3, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1.1
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
                                            left3.element = f4;
                                            List $this$fastForEachIndexed$iv = tabPlaceables3;
                                            MeasureScope measureScope2 = $this$Layout;
                                            Ref.FloatRef floatRef = left3;
                                            List<TabPosition> list2 = positions2;
                                            int index$iv = 0;
                                            int size4 = $this$fastForEachIndexed$iv.size();
                                            while (index$iv < size4) {
                                                Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                                int index2 = index$iv;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, measureScope2.mo361roundToPx0680j_4(floatRef.element), 0, 0.0f, 4, null);
                                                float arg0$iv3 = floatRef.element;
                                                float other$iv2 = list2.get(index2).getWidth();
                                                floatRef.element = Dp.m6693constructorimpl(arg0$iv3 + other$iv2);
                                                index$iv++;
                                                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv;
                                            }
                                            List $this$fastForEach$iv = dividerPlaceables;
                                            int i6 = layoutHeight;
                                            int size5 = $this$fastForEach$iv.size();
                                            for (int index$iv2 = 0; index$iv2 < size5; index$iv2++) {
                                                Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                                Placeable placeable = (Placeable) item$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i6 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List $this$fastForEach$iv2 = indicatorPlaceables;
                                            MeasureScope measureScope3 = $this$Layout;
                                            List<TabPosition> list3 = positions2;
                                            int i7 = i5;
                                            int i8 = layoutHeight;
                                            int size6 = $this$fastForEach$iv2.size();
                                            for (int index$iv3 = 0; index$iv3 < size6; index$iv3++) {
                                                Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                                                Placeable it4 = (Placeable) item$iv3;
                                                int relativeOffset = Math.max(0, (measureScope3.mo361roundToPx0680j_4(list3.get(i7).getWidth()) - it4.getWidth()) / 2);
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it4, relativeOffset, i8 - it4.getHeight(), 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut($this$Layout, padding, positions2, i5);
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                            i = 0;
                        }
                        MultiContentMeasurePolicy measurePolicy$iv = (MultiContentMeasurePolicy) value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int $changed$iv = i;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(contents$iv);
                        ComposerKt.sourceInformationMarkerStart($composer4, -290761997, "CC(remember):Layout.kt#9igjgp");
                        boolean invalid$iv$iv = ((($changed$iv & 896) ^ 384) > 256 && $composer4.changed(measurePolicy$iv)) || ($changed$iv & 384) == 256;
                        Object it$iv$iv2 = $composer4.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy$iv);
                            $composer4.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int $changed$iv$iv = $changed$iv & 112;
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
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        content$iv$iv.invoke($composer4, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
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
            }, $composer3, 54), $composer2, ($dirty & 896) | 12582912 | ($dirty & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$2
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
                    TabRowKt.m2612ScrollableTabRowImplsKfQg0A(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, scrollState, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m2618TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long containerColor, final long contentColor, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Modifier modifier2;
        long j;
        long j2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation($composer3, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)947@41323L2218,943@41193L2348:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            j = containerColor;
            $dirty |= $composer3.changed(j) ? 32 : 16;
        } else {
            j = containerColor;
        }
        if (($changed & 384) == 0) {
            j2 = contentColor;
            $dirty |= $composer3.changed(j2) ? 256 : 128;
        } else {
            j2 = contentColor;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & $dirty) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, $dirty, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:942)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C948@41375L2160,948@41333L2202:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, $changed2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:948)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1807613681, "CC(remember):TabRow.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function22) | $composer4.changed(function2) | $composer4.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2626invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2626invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                int tabRowWidth = Constraints.m6636getMaxWidthimpl(constraints);
                                List tabMeasurables = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                int tabCount = tabMeasurables.size();
                                final Ref.IntRef tabWidth = new Ref.IntRef();
                                if (tabCount > 0) {
                                    tabWidth.element = tabRowWidth / tabCount;
                                }
                                Object accumulator$iv = 0;
                                int index$iv$iv = 0;
                                int size = tabMeasurables.size();
                                while (index$iv$iv < size) {
                                    Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                    Measurable curr = (Measurable) item$iv$iv;
                                    int max = ((Number) accumulator$iv).intValue();
                                    accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                    index$iv$iv++;
                                    tabRowWidth = tabRowWidth;
                                }
                                final int tabRowWidth2 = tabRowWidth;
                                final int $i$f$fastForEach = ((Number) accumulator$iv).intValue();
                                List $this$fastMap$iv = tabMeasurables;
                                int $i$f$fastMap = 0;
                                List $this$fastForEach$iv$iv = new ArrayList($this$fastMap$iv.size());
                                List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
                                int $i$f$fastForEach2 = 0;
                                int index$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv2.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                                    List $this$fastMap$iv2 = $this$fastMap$iv;
                                    int $i$f$fastMap2 = $i$f$fastMap;
                                    Measurable it = (Measurable) item$iv$iv2;
                                    List target$iv = $this$fastForEach$iv$iv;
                                    int i = $i$f$fastForEach;
                                    int tabRowHeight = $i$f$fastForEach;
                                    $i$f$fastForEach = tabRowHeight;
                                    $this$fastForEach$iv$iv.add(it.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, tabWidth.element, tabWidth.element, tabRowHeight, i)));
                                    index$iv$iv2++;
                                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                                    $this$fastMap$iv = $this$fastMap$iv2;
                                    $i$f$fastMap = $i$f$fastMap2;
                                    $this$fastForEach$iv$iv = target$iv;
                                    $i$f$fastForEach2 = $i$f$fastForEach2;
                                }
                                List target$iv2 = $this$fastForEach$iv$iv;
                                final List tabPlaceables = target$iv2;
                                ArrayList arrayList = new ArrayList(tabCount);
                                int i2 = 0;
                                while (i2 < tabCount) {
                                    int index = i2;
                                    float contentWidth = $this$SubcomposeLayout.mo364toDpu2uoSUM(Math.min(tabMeasurables.get(index).maxIntrinsicWidth($i$f$fastForEach), tabWidth.element));
                                    float arg0$iv = TabKt.getHorizontalTextPadding();
                                    float other$iv = Dp.m6693constructorimpl(contentWidth - Dp.m6693constructorimpl(2 * arg0$iv));
                                    float indicatorWidth = ((Dp) ComparisonsKt.maxOf(Dp.m6691boximpl(other$iv), Dp.m6691boximpl(Dp.m6693constructorimpl(24)))).m6707unboximpl();
                                    float arg0$iv2 = $this$SubcomposeLayout.mo364toDpu2uoSUM(tabWidth.element);
                                    arrayList.add(new TabPosition(Dp.m6693constructorimpl(index * arg0$iv2), $this$SubcomposeLayout.mo364toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                    i2++;
                                    tabPlaceables = tabPlaceables;
                                }
                                final ArrayList tabPositions = arrayList;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.CC.layout$default($this$SubcomposeLayout, tabRowWidth2, $i$f$fastForEach, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
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
                                        List $this$fastForEachIndexed$iv = tabPlaceables;
                                        Ref.IntRef intRef = tabWidth;
                                        int size3 = $this$fastForEachIndexed$iv.size();
                                        for (int index$iv = 0; index$iv < size3; index$iv++) {
                                            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                            int index2 = index$iv;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                        }
                                        List $this$fastForEach$iv = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                        long j3 = constraints;
                                        int i3 = $i$f$fastForEach;
                                        int size4 = $this$fastForEach$iv.size();
                                        for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                                            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                            Measurable it2 = (Measurable) item$iv2;
                                            Placeable placeable = it2.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(j3, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(j3) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(j3) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(j3) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(j3) : 0));
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i3 - placeable.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list = tabPositions;
                                        List $this$fastForEach$iv2 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
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
                                                ComposerKt.sourceInformation($composer5, "C994@43328L23:TabRow.kt#uh7d8r");
                                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                                    $composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, $changed3, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:994)");
                                                }
                                                function34.invoke(list, $composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i4 = tabRowWidth2;
                                        int i5 = $i$f$fastForEach;
                                        int size5 = $this$fastForEach$iv2.size();
                                        for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                                            Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                                            Measurable it3 = (Measurable) item$iv3;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5535measureBRTryo0(Constraints.INSTANCE.m6646fixedJhjzzOo(i4, i5)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) value$iv, $composer4, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer2, (($dirty << 3) & 896) | 12582912 | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
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
                    TabRowKt.m2618TabRowWithSubcomposeImplDTcfvLk(modifier3, containerColor, contentColor, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4, reason: not valid java name */
    public static final void m2613ScrollableTabRowWithSubcomposeImplqhFBPw4(final int selectedTabIndex, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer $composer, final int $changed, final int i) {
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int $dirty;
        long containerColor3;
        long contentColor3;
        float edgePadding3;
        int i2;
        Function2 divider;
        Modifier modifier3;
        int i3;
        Composer $composer2;
        final Modifier modifier4;
        final float edgePadding4;
        final Function2 divider2;
        final long containerColor4;
        final long contentColor4;
        Composer $composer3 = $composer.startRestartGroup(-955409947);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRowWithSubcomposeImpl)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)1008@43780L21,1009@43844L19,1015@44165L3880,1015@44083L3962:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            function32 = function3;
        } else if (($changed & 48) == 0) {
            function32 = function3;
            $dirty2 |= $composer3.changedInstance(function32) ? 32 : 16;
        } else {
            function32 = function3;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(scrollState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            edgePadding4 = edgePadding2;
            divider2 = function2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2607getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    i2 = 12582912;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m2007getLambda7$material3_release();
                    edgePadding3 = edgePadding2;
                    modifier3 = modifier2;
                    i3 = -955409947;
                } else {
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    divider = function2;
                    modifier3 = modifier2;
                    i3 = -955409947;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    int i9 = $dirty2 & (-57345);
                    divider = function2;
                    $dirty = i9;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    modifier3 = modifier2;
                    i3 = -955409947;
                } else {
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    divider = function2;
                    modifier3 = modifier2;
                    i3 = -955409947;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:1014)");
            }
            final float edgePadding5 = edgePadding3;
            final Function2 divider3 = divider;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(modifier3, null, containerColor3, contentColor3, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1572959552, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
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
                    Object value$iv$iv;
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C1016@44196L24,1018@44265L147,1027@44663L3376,1021@44421L3618:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1572959552, $changed2, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:1016)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer4, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, -702892231, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(scrollState) | $composer4.changed(coroutineScope);
                        ScrollState scrollState2 = scrollState;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new ScrollableTabData(scrollState2, coroutineScope);
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
                        ComposerKt.sourceInformationMarkerStart($composer4, -702876266, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(edgePadding5) | $composer4.changed(function22) | $composer4.changed(divider3) | $composer4.changed(function33) | $composer4.changedInstance(scrollableTabData) | $composer4.changed(selectedTabIndex);
                        final float f = edgePadding5;
                        final Function2<Composer, Integer, Unit> function23 = function22;
                        final Function2<Composer, Integer, Unit> function24 = divider3;
                        final int i10 = selectedTabIndex;
                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                        Object value$iv2 = $composer4.rememberedValue();
                        if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m2624invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2624invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                    int minTabWidth = $this$SubcomposeLayout.mo361roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    int padding = $this$SubcomposeLayout.mo361roundToPx0680j_4(f);
                                    List tabMeasurables = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                    Object initial$iv = 0;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = tabMeasurables.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                        Object initial$iv2 = initial$iv;
                                        Measurable measurable = (Measurable) item$iv$iv;
                                        int curr = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr, measurable.maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        index$iv$iv++;
                                        initial$iv = initial$iv2;
                                        padding = padding;
                                    }
                                    final int padding2 = padding;
                                    final int layoutHeight = ((Number) accumulator$iv).intValue();
                                    long tabConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : minTabWidth, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : layoutHeight, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : layoutHeight);
                                    final List tabPlaceables = new ArrayList();
                                    final List tabContentWidths = new ArrayList();
                                    int index$iv = 0;
                                    int size2 = tabMeasurables.size();
                                    while (index$iv < size2) {
                                        Object item$iv = tabMeasurables.get(index$iv);
                                        Measurable it = (Measurable) item$iv;
                                        Placeable placeable = it.mo5535measureBRTryo0(tabConstraints);
                                        long tabConstraints2 = tabConstraints;
                                        float contentWidth = $this$SubcomposeLayout.mo364toDpu2uoSUM(Math.min(it.maxIntrinsicWidth(placeable.getHeight()), placeable.getWidth()));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        float arg0$iv2 = 2;
                                        float other$iv = Dp.m6693constructorimpl(arg0$iv2 * arg0$iv);
                                        float other$iv2 = Dp.m6693constructorimpl(contentWidth - other$iv);
                                        tabPlaceables.add(placeable);
                                        tabContentWidths.add(Dp.m6691boximpl(other$iv2));
                                        index$iv++;
                                        tabConstraints = tabConstraints2;
                                    }
                                    Object accumulator$iv2 = Integer.valueOf(padding2 * 2);
                                    int size3 = tabPlaceables.size();
                                    for (int index$iv$iv2 = 0; index$iv$iv2 < size3; index$iv$iv2++) {
                                        Object item$iv$iv2 = tabPlaceables.get(index$iv$iv2);
                                        Placeable measurable2 = (Placeable) item$iv$iv2;
                                        int curr2 = ((Number) accumulator$iv2).intValue();
                                        accumulator$iv2 = Integer.valueOf(curr2 + measurable2.getWidth());
                                    }
                                    final int layoutWidth = ((Number) accumulator$iv2).intValue();
                                    final Function2<Composer, Integer, Unit> function25 = function24;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i11 = i10;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                    return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1.2
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
                                            final List tabPositions = new ArrayList();
                                            int left = padding2;
                                            List $this$fastForEachIndexed$iv = tabPlaceables;
                                            SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                            List<Dp> list = tabContentWidths;
                                            int size4 = $this$fastForEachIndexed$iv.size();
                                            int left2 = left;
                                            for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                                                Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv2);
                                                Placeable placeable2 = (Placeable) item$iv2;
                                                int index = index$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, left2, 0, 0.0f, 4, null);
                                                tabPositions.add(new TabPosition(subcomposeMeasureScope.mo364toDpu2uoSUM(left2), subcomposeMeasureScope.mo364toDpu2uoSUM(placeable2.getWidth()), list.get(index).m6707unboximpl(), null));
                                                left2 += placeable2.getWidth();
                                            }
                                            List $this$fastForEach$iv = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                            long j = constraints;
                                            int i12 = layoutWidth;
                                            int i13 = layoutHeight;
                                            int size5 = $this$fastForEach$iv.size();
                                            int index$iv3 = 0;
                                            while (index$iv3 < size5) {
                                                Object item$iv3 = $this$fastForEach$iv.get(index$iv3);
                                                Measurable it2 = (Measurable) item$iv3;
                                                Placeable placeable3 = it2.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(j) : i12, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(j) : i12, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(j) : 0));
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable3, 0, i13 - placeable3.getHeight(), 0.0f, 4, null);
                                                index$iv3++;
                                                $this$fastForEach$iv = $this$fastForEach$iv;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                            List $this$fastForEach$iv2 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1734082948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowWithSubcomposeImpl.1.1.1.2.3
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
                                                    ComposerKt.sourceInformation($composer5, "C1094@47573L23:TabRow.kt#uh7d8r");
                                                    if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                                        $composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1734082948, $changed3, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1094)");
                                                    }
                                                    function36.invoke(tabPositions, $composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i14 = layoutWidth;
                                            int i15 = layoutHeight;
                                            int size6 = $this$fastForEach$iv2.size();
                                            for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                                                Object item$iv4 = $this$fastForEach$iv2.get(index$iv4);
                                                Measurable it3 = (Measurable) item$iv4;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5535measureBRTryo0(Constraints.INSTANCE.m6646fixedJhjzzOo(i14, i15)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut($this$SubcomposeLayout, padding2, tabPositions, i11);
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) value$iv2, $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty >> 6) & 14) | i2 | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            edgePadding4 = edgePadding5;
            divider2 = divider3;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$2
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
                    TabRowKt.m2613ScrollableTabRowWithSubcomposeImplqhFBPw4(selectedTabIndex, function3, modifier4, containerColor4, contentColor4, edgePadding4, divider2, function22, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
