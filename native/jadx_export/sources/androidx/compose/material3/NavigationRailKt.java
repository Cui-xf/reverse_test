package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: NavigationRail.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0081\u0001\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationRailKt.IconLayoutIdTag, "enabled", NavigationRailKt.LabelLayoutIdTag, "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailVerticalPadding = Dp.m6693constructorimpl(4);
    private static final float NavigationRailHeaderPadding = Dp.m6693constructorimpl(8);
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m3349getContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m3352getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding = Dp.m6693constructorimpl(4);

    /* renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    public static final void m2353NavigationRailqi6gXK8(Modifier modifier, long containerColor, long contentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 header;
        WindowInsets windowInsets2;
        long contentColor3;
        final WindowInsets windowInsets3;
        Modifier modifier3;
        int $dirty;
        final Function3 header2;
        long containerColor3;
        Composer $composer2;
        final Function3 header3;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long containerColor4;
        final long contentColor4;
        Composer $composer3 = $composer.startRestartGroup(118552648);
        ComposerKt.sourceInformation($composer3, "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)113@5242L14,114@5284L31,116@5431L12,123@5614L618,119@5501L731:NavigationRail.kt#uh7d8r");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            header = function3;
        } else if (($changed & 3072) == 0) {
            header = function3;
            $dirty2 |= $composer3.changedInstance(header) ? 2048 : 1024;
        } else {
            header = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty2 |= $composer3.changedInstance(function32) ? 131072 : 65536;
        }
        if ((74899 & $dirty2) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            windowInsets4 = windowInsets2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            header3 = header;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                    containerColor2 = NavigationRailDefaults.INSTANCE.getContainerColor($composer3, 6);
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m1948contentColorForek8zF_U(containerColor2, $composer3, ($dirty2 >> 3) & 14);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    header = null;
                }
                if ((i & 16) != 0) {
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    contentColor3 = contentColor2;
                    modifier3 = modifier5;
                    $dirty = $dirty2 & (-57345);
                    header2 = header;
                    containerColor3 = containerColor2;
                } else {
                    contentColor3 = contentColor2;
                    windowInsets3 = windowInsets2;
                    modifier3 = modifier5;
                    $dirty = $dirty2;
                    header2 = header;
                    containerColor3 = containerColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    contentColor3 = contentColor2;
                    header2 = header;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                    containerColor3 = containerColor2;
                } else {
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                    header2 = header;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                    containerColor3 = containerColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118552648, $dirty, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:118)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(modifier3, null, containerColor3, contentColor3, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
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
                    ComposerKt.sourceInformation($composer4, "C124@5624L602:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2092683357, $changed2, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:124)");
                        }
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m683paddingVpY3zN4$default(SizeKt.m733widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), NavigationRailTokens.INSTANCE.m3349getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM557spacedBy0680j_4 = Arrangement.INSTANCE.m557spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                        Function3<ColumnScope, Composer, Integer, Unit> function33 = header2;
                        Function3<ColumnScope, Composer, Integer, Unit> function34 = function32;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM557spacedBy0680j_4, centerHorizontally, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifierSelectableGroup);
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
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        int $changed3 = ((432 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 933375077, "C137@6207L9:NavigationRail.kt#uh7d8r");
                        $composer4.startReplaceGroup(722845512);
                        ComposerKt.sourceInformation($composer4, "134@6103L8,135@6128L52");
                        if (function33 != null) {
                            function33.invoke($this$invoke_u24lambda_u240, $composer4, Integer.valueOf($changed3 & 14));
                            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.NavigationRailHeaderPadding), $composer4, 6);
                        }
                        $composer4.endReplaceGroup();
                        function34.invoke($this$invoke_u24lambda_u240, $composer4, Integer.valueOf($changed3 & 14));
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
            }, $composer3, 54), $composer2, ($dirty & 14) | 12582912 | (($dirty << 3) & 896) | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            header3 = header2;
            windowInsets4 = windowInsets3;
            modifier4 = modifier3;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$2
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

                public final void invoke(Composer composer, int i7) {
                    NavigationRailKt.m2353NavigationRailqi6gXK8(modifier4, containerColor4, contentColor4, header3, windowInsets4, function32, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x050d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavigationRailItem(final boolean r48, final kotlin.jvm.functions.Function0<kotlin.Unit> r49, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.ui.Modifier r51, boolean r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, boolean r54, androidx.compose.material3.NavigationRailItemColors r55, androidx.compose.foundation.interaction.MutableInteractionSource r56, androidx.compose.runtime.Composer r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean alwaysShowLabel, final Function0<Float> function0, Composer $composer, final int $changed) {
        MeasurePolicy value$iv;
        Function0 factory$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Object value$iv2;
        Function0 factory$iv$iv$iv2;
        int $changed$iv;
        Composer $composer3 = $composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation($composer3, "C(NavigationRailItemLayout)P(4,3,2,5)530@23300L1924,515@22904L2320:NavigationRail.kt#uh7d8r");
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
            $dirty |= $composer3.changedInstance(function24) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(alwaysShowLabel) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498399348, $dirty, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1881815062, "CC(remember):NavigationRail.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | (($dirty & 458752) == 131072) | (($dirty & 57344) == 16384);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$2$1
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
                        Placeable placeableMo5535measureBRTryo0;
                        Object it$iv2;
                        MeasureScope measureScope = $this$Layout;
                        float animationProgress = function0.invoke().floatValue();
                        long looseConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
                        List $this$fastFirst$iv = list;
                        int $i$f$fastFirst = 0;
                        int index$iv$iv = 0;
                        int size = $this$fastFirst$iv.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastFirst$iv.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            List $this$fastFirst$iv2 = $this$fastFirst$iv;
                            int $i$f$fastFirst2 = $i$f$fastFirst;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "icon")) {
                                Placeable iconPlaceable = ((Measurable) item$iv$iv).mo5535measureBRTryo0(looseConstraints);
                                int width = iconPlaceable.getWidth();
                                float arg0$iv = NavigationRailKt.IndicatorHorizontalPadding;
                                int totalIndicatorWidth = width + measureScope.mo361roundToPx0680j_4(Dp.m6693constructorimpl(2 * arg0$iv));
                                int animatedIndicatorWidth = MathKt.roundToInt(totalIndicatorWidth * animationProgress);
                                float indicatorVerticalPadding = function24 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel;
                                int height = iconPlaceable.getHeight();
                                int other$iv = measureScope.mo361roundToPx0680j_4(Dp.m6693constructorimpl(2 * indicatorVerticalPadding));
                                int indicatorHeight = height + other$iv;
                                int index$iv$iv2 = 0;
                                int size2 = list.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    int i = size2;
                                    Placeable iconPlaceable2 = iconPlaceable;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "indicatorRipple")) {
                                        Placeable indicatorRipplePlaceable = ((Measurable) item$iv$iv2).mo5535measureBRTryo0(Constraints.INSTANCE.m6646fixedJhjzzOo(totalIndicatorWidth, indicatorHeight));
                                        List $this$fastFirstOrNull$iv = list;
                                        int $i$f$fastFirstOrNull = 0;
                                        int index$iv$iv3 = 0;
                                        int size3 = $this$fastFirstOrNull$iv.size();
                                        while (true) {
                                            placeableMo5535measureBRTryo0 = null;
                                            if (index$iv$iv3 >= size3) {
                                                it$iv2 = null;
                                                break;
                                            }
                                            it$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv3);
                                            Measurable it3 = (Measurable) it$iv2;
                                            List $this$fastFirstOrNull$iv2 = $this$fastFirstOrNull$iv;
                                            int $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "indicator")) {
                                                break;
                                            }
                                            index$iv$iv3++;
                                            $this$fastFirstOrNull$iv = $this$fastFirstOrNull$iv2;
                                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                        }
                                        Measurable measurable = (Measurable) it$iv2;
                                        Placeable indicatorPlaceable = measurable != null ? measurable.mo5535measureBRTryo0(Constraints.INSTANCE.m6646fixedJhjzzOo(animatedIndicatorWidth, indicatorHeight)) : null;
                                        if (function24 != null) {
                                            int size4 = list.size();
                                            int index$iv$iv4 = 0;
                                            while (index$iv$iv4 < size4) {
                                                Object item$iv$iv3 = list.get(index$iv$iv4);
                                                Measurable it4 = (Measurable) item$iv$iv3;
                                                int i2 = size4;
                                                int index$iv$iv5 = index$iv$iv4;
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "label")) {
                                                    placeableMo5535measureBRTryo0 = ((Measurable) item$iv$iv3).mo5535measureBRTryo0(looseConstraints);
                                                } else {
                                                    index$iv$iv4 = index$iv$iv5 + 1;
                                                    size4 = i2;
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        Placeable labelPlaceable = placeableMo5535measureBRTryo0;
                                        if (function24 == null) {
                                            return NavigationRailKt.m2356placeIconX9ElhV4($this$Layout, iconPlaceable2, indicatorRipplePlaceable, indicatorPlaceable, constraints);
                                        }
                                        Intrinsics.checkNotNull(labelPlaceable);
                                        return NavigationRailKt.m2357placeLabelAndIconzUg2_y0($this$Layout, labelPlaceable, iconPlaceable2, indicatorRipplePlaceable, indicatorPlaceable, constraints, alwaysShowLabel, animationProgress);
                                    }
                                    iconPlaceable = iconPlaceable2;
                                    index$iv$iv2++;
                                    size2 = i;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            index$iv$iv++;
                            measureScope = $this$Layout;
                            $this$fastFirst$iv = $this$fastFirst$iv2;
                            $i$f$fastFirst = $i$f$fastFirst2;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $dirty2 = $dirty;
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
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
            $composer2 = $composer3;
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2082816907, "C516@22921L17,517@22947L11,519@22968L50:NavigationRail.kt#uh7d8r");
            function2.invoke($composer2, Integer.valueOf($dirty2 & 14));
            function22.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 402566553, "C519@23010L6:NavigationRail.kt#uh7d8r");
            function23.invoke($composer2, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(2145400941);
            ComposerKt.sourceInformation($composer2, "523@23132L96,522@23061L221");
            if (function24 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, LabelLayoutIdTag);
                ComposerKt.sourceInformationMarkerStart($composer2, 2145404101, "CC(remember):NavigationRail.kt#9igjgp");
                boolean invalid$iv2 = (($dirty2 & 57344) == 16384) | (($dirty2 & 458752) == 131072);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                            $this$graphicsLayer.setAlpha(alwaysShowLabel ? 1.0f : function0.invoke().floatValue());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv3 = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) value$iv2);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    $changed$iv = 0;
                } else {
                    $changed$iv = 0;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    int i5 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
                    function24.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i42 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                int i52 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
                function24.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemLayout.3
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

                public final void invoke(Composer composer, int i6) {
                    NavigationRailKt.NavigationRailItemLayout(function2, function22, function23, function24, alwaysShowLabel, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2356placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints) {
        final int width = ConstraintsKt.m6653constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(indicatorRipplePlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        final int height = ConstraintsKt.m6652constrainHeightK40F9xA(constraints, $this$placeIcon_u2dX9ElhV4.mo361roundToPx0680j_4(NavigationRailItemHeight));
        final int iconX = (width - iconPlaceable.getWidth()) / 2;
        final int iconY = (height - iconPlaceable.getHeight()) / 2;
        final int rippleX = (width - indicatorRipplePlaceable.getWidth()) / 2;
        final int rippleY = (height - indicatorRipplePlaceable.getHeight()) / 2;
        return MeasureScope.CC.layout$default($this$placeIcon_u2dX9ElhV4, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
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
                Placeable it = indicatorPlaceable;
                if (it != null) {
                    int i = width;
                    int i2 = height;
                    int indicatorX = (i - it.getWidth()) / 2;
                    int indicatorY = (i2 - it.getHeight()) / 2;
                    Placeable.PlacementScope.placeRelative$default($this$layout, it, indicatorX, indicatorY, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, iconPlaceable, iconX, iconY, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default($this$layout, indicatorRipplePlaceable, rippleX, rippleY, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2357placeLabelAndIconzUg2_y0(final MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, final Placeable labelPlaceable, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints, final boolean alwaysShowLabel, final float animationProgress) {
        float contentHeight = iconPlaceable.getHeight() + $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(IndicatorVerticalPaddingWithLabel) + $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(NavigationRailItemVerticalPadding) + labelPlaceable.getHeight();
        final float contentVerticalPadding = RangesKt.coerceAtLeast((Constraints.m6637getMinHeightimpl(constraints) - contentHeight) / 2.0f, $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(IndicatorVerticalPaddingWithLabel));
        float height = contentHeight + (contentVerticalPadding * 2.0f);
        float unselectedIconY = alwaysShowLabel ? contentVerticalPadding : (height - iconPlaceable.getHeight()) / 2.0f;
        float iconDistance = unselectedIconY - contentVerticalPadding;
        final float offset = iconDistance * (1.0f - animationProgress);
        final float labelY = iconPlaceable.getHeight() + contentVerticalPadding + $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(IndicatorVerticalPaddingWithLabel) + $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(NavigationRailItemVerticalPadding);
        final int width = ConstraintsKt.m6653constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(labelPlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        final int labelX = (width - labelPlaceable.getWidth()) / 2;
        final int iconX = (width - iconPlaceable.getWidth()) / 2;
        final int rippleX = (width - indicatorRipplePlaceable.getWidth()) / 2;
        final float rippleY = contentVerticalPadding - $this$placeLabelAndIcon_u2dzUg2_y0.mo367toPx0680j_4(IndicatorVerticalPaddingWithLabel);
        return MeasureScope.CC.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, width, MathKt.roundToInt(height), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r21) {
                /*
                    r20 = this;
                    r0 = r20
                    androidx.compose.ui.layout.Placeable r1 = r17
                    if (r1 == 0) goto L2f
                    int r2 = r30
                    float r3 = r26
                    androidx.compose.ui.layout.MeasureScope r4 = r31
                    float r5 = r23
                    r7 = r1
                    r1 = 0
                    int r6 = r7.getWidth()
                    int r2 = r2 - r6
                    int r8 = r2 / 2
                    float r2 = androidx.compose.material3.NavigationRailKt.access$getIndicatorVerticalPaddingWithLabel$p()
                    float r2 = r4.mo367toPx0680j_4(r2)
                    float r3 = r3 - r2
                    float r5 = r5 + r3
                    int r9 = kotlin.math.MathKt.roundToInt(r5)
                    r11 = 4
                    r12 = 0
                    r10 = 0
                    r6 = r21
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r6, r7, r8, r9, r10, r11, r12)
                L2f:
                    boolean r1 = r18
                    if (r1 != 0) goto L3f
                    float r1 = r19
                    r2 = 0
                    int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                    if (r1 != 0) goto L3c
                    r1 = 1
                    goto L3d
                L3c:
                    r1 = 0
                L3d:
                    if (r1 != 0) goto L57
                L3f:
                    androidx.compose.ui.layout.Placeable r14 = r20
                    int r15 = r21
                    float r1 = r22
                    float r2 = r23
                    float r1 = r1 + r2
                    int r16 = kotlin.math.MathKt.roundToInt(r1)
                    r18 = 4
                    r19 = 0
                    r17 = 0
                    r13 = r21
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r13, r14, r15, r16, r17, r18, r19)
                L57:
                    androidx.compose.ui.layout.Placeable r14 = r24
                    int r15 = r25
                    float r1 = r26
                    float r2 = r23
                    float r1 = r1 + r2
                    int r16 = kotlin.math.MathKt.roundToInt(r1)
                    r18 = 4
                    r19 = 0
                    r17 = 0
                    r13 = r21
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r13, r14, r15, r16, r17, r18, r19)
                    androidx.compose.ui.layout.Placeable r14 = r27
                    int r15 = r28
                    float r1 = r29
                    float r2 = r23
                    float r1 = r1 + r2
                    int r16 = kotlin.math.MathKt.roundToInt(r1)
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r13, r14, r15, r16, r17, r18, r19)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
            }
        }, 4, null);
    }

    static {
        float arg0$iv = NavigationRailTokens.INSTANCE.m3347getActiveIndicatorWidthD9Ej5fM();
        float other$iv = NavigationRailTokens.INSTANCE.m3350getIconSizeD9Ej5fM();
        IndicatorHorizontalPadding = Dp.m6693constructorimpl(Dp.m6693constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = NavigationRailTokens.INSTANCE.m3346getActiveIndicatorHeightD9Ej5fM();
        float other$iv2 = NavigationRailTokens.INSTANCE.m3350getIconSizeD9Ej5fM();
        IndicatorVerticalPaddingWithLabel = Dp.m6693constructorimpl(Dp.m6693constructorimpl(arg0$iv2 - other$iv2) / 2);
        float arg0$iv3 = NavigationRailTokens.INSTANCE.m3352getNoLabelActiveIndicatorHeightD9Ej5fM();
        float other$iv3 = NavigationRailTokens.INSTANCE.m3350getIconSizeD9Ej5fM();
        IndicatorVerticalPaddingNoLabel = Dp.m6693constructorimpl(Dp.m6693constructorimpl(arg0$iv3 - other$iv3) / 2);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }
}
