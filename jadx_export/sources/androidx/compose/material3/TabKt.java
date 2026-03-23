package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0082\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3477getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m6693constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m6693constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m6693constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m6693constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m6693constructorimpl(8);

    /* renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m2597TabwqdebIU(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        final Function2 text;
        final Function2 icon;
        int $dirty;
        int i2;
        int i3;
        int i4;
        long selectedContentColor2;
        long unselectedContentColor2;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        long selectedContentColor3;
        int i5;
        long unselectedContentColor3;
        final Function2 styledText;
        Composer $composer2;
        final Function2 text2;
        final Function2 icon2;
        final Modifier modifier3;
        final boolean enabled4;
        final long selectedContentColor4;
        final long unselectedContentColor4;
        final MutableInteractionSource interactionSource3;
        int $dirty2;
        Composer $composer3 = $composer.startRestartGroup(-350627181);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4483L7,121@5133L65,113@4964L234:Tab.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
            z = selected;
        } else if (($changed & 6) == 0) {
            z = selected;
            $dirty3 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty3 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty3 |= 24576;
            text = function2;
        } else if (($changed & 24576) == 0) {
            text = function2;
            $dirty3 |= $composer3.changedInstance(text) ? 16384 : 8192;
        } else {
            text = function2;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            icon = function22;
        } else if ((196608 & $changed) == 0) {
            icon = function22;
            $dirty3 |= $composer3.changedInstance(icon) ? 131072 : 65536;
        } else {
            icon = function22;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty2 = $dirty3;
                i2 = i6;
                int i10 = $composer3.changed(selectedContentColor) ? 1048576 : 524288;
                $dirty = $dirty2 | i10;
            } else {
                $dirty2 = $dirty3;
                i2 = i6;
            }
            $dirty = $dirty2 | i10;
        } else {
            $dirty = $dirty3;
            i2 = i6;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(unselectedContentColor)) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            i3 = i11;
        } else if (($changed & 100663296) == 0) {
            i3 = i11;
            $dirty |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i11;
        }
        if (($dirty & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            enabled4 = enabled2;
            text2 = text;
            icon2 = icon;
            selectedContentColor4 = selectedContentColor;
            unselectedContentColor4 = unselectedContentColor;
            interactionSource3 = interactionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    enabled2 = true;
                }
                if (i8 != 0) {
                    text = null;
                }
                if (i9 != 0) {
                    icon = null;
                }
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    i4 = -29360129;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor2 = ((Color) objConsume).m4197unboximpl();
                    $dirty &= -3670017;
                } else {
                    i4 = -29360129;
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty &= i4;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                }
                if (i3 != 0) {
                    interactionSource2 = null;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    i5 = -350627181;
                    unselectedContentColor3 = unselectedContentColor2;
                } else {
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    i5 = -350627181;
                    unselectedContentColor3 = unselectedContentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty &= -29360129;
                    enabled3 = enabled2;
                    i5 = -350627181;
                } else {
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    i5 = -350627181;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:102)");
            }
            $composer3.startReplaceGroup(79583089);
            ComposerKt.sourceInformation($composer3, "*105@4702L247");
            if (text == null) {
                styledText = null;
            } else {
                Function2 it = ComposableLambdaKt.rememberComposableLambda(708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
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
                        ComposerKt.sourceInformation($composer4, "C107@4793L5,110@4896L39:Tab.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(708874428, $changed2, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:106)");
                            }
                            TextStyle style = TextStyle.m6159copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), $composer4, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6550getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                            TextKt.ProvideTextStyle(style, text, $composer4, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54);
                styledText = it;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            Modifier modifier4 = modifier2;
            m2596TabbogVsAg(z, function02, modifier4, enabled3, selectedContentColor3, unselectedContentColor3, interactionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope $this$Tab, Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C122@5143L49:Tab.kt#uh7d8r");
                    if (($changed2 & 17) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1540996038, $changed2, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                        }
                        TabKt.TabBaselineLayout(styledText, icon, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (3670016 & ($dirty >> 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            text2 = text;
            icon2 = icon;
            modifier3 = modifier4;
            enabled4 = enabled3;
            selectedContentColor4 = selectedContentColor3;
            unselectedContentColor4 = unselectedContentColor3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
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
                    TabKt.m2597TabwqdebIU(selected, function0, modifier3, enabled4, text2, icon2, selectedContentColor4, unselectedContentColor4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m2595LeadingIconTabwqdebIU(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean enabled2;
        long j;
        int $dirty;
        int i2;
        int i3;
        long selectedContentColor2;
        long unselectedContentColor2;
        final Modifier modifier3;
        long unselectedContentColor3;
        final MutableInteractionSource interactionSource2;
        final boolean enabled3;
        Composer $composer2;
        final long unselectedContentColor4;
        final long selectedContentColor3;
        final Modifier modifier4;
        final boolean enabled4;
        final MutableInteractionSource interactionSource3;
        int $dirty2;
        Composer $composer3 = $composer.startRestartGroup(-777316544);
        ComposerKt.sourceInformation($composer3, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)164@7036L7,171@7399L76,173@7551L950,173@7481L1020:Tab.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty3 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
            function23 = function2;
        } else if (($changed & 384) == 0) {
            function23 = function2;
            $dirty3 |= $composer3.changedInstance(function23) ? 256 : 128;
        } else {
            function23 = function2;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
            function24 = function22;
        } else if (($changed & 3072) == 0) {
            function24 = function22;
            $dirty3 |= $composer3.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function22;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enabled2 = enabled;
        } else if ((196608 & $changed) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = selectedContentColor;
                int i6 = $composer3.changed(j) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                j = selectedContentColor;
            }
            $dirty3 |= i6;
        } else {
            j = selectedContentColor;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty2 = $dirty3;
                int i7 = $composer3.changed(unselectedContentColor) ? 8388608 : 4194304;
                $dirty = $dirty2 | i7;
            } else {
                $dirty2 = $dirty3;
            }
            $dirty = $dirty2 | i7;
        } else {
            $dirty = $dirty3;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
            i2 = i8;
        } else if (($changed & 100663296) == 0) {
            i2 = i8;
            $dirty |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i8;
        }
        if (($dirty & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            enabled4 = enabled2;
            selectedContentColor3 = j;
            unselectedContentColor4 = unselectedContentColor;
            $composer2 = $composer3;
            interactionSource3 = interactionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    i3 = -29360129;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor2 = ((Color) objConsume).m4197unboximpl();
                    $dirty &= -3670017;
                } else {
                    i3 = -29360129;
                    selectedContentColor2 = j;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty &= i3;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                }
                if (i2 != 0) {
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor2;
                    interactionSource2 = null;
                    enabled3 = enabled2;
                } else {
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor2;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    interactionSource2 = interactionSource;
                    $dirty &= -29360129;
                    enabled3 = enabled2;
                    selectedContentColor2 = j;
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor;
                } else {
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor2 = j;
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, $dirty, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:167)");
            }
            final Indication ripple = RippleKt.m2425rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, selectedContentColor2, $composer3, (($dirty >> 12) & 896) | 6, 2);
            final Function0<Unit> function03 = function02;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
            long unselectedContentColor5 = unselectedContentColor3;
            m2598TabTransitionKlgxPg(selectedContentColor2, unselectedContentColor5, selected, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C174@7561L934:Tab.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-429037564, $changed2, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                        }
                        Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.m683paddingVpY3zN4$default(SelectableKt.m939selectableO2vRcR0(SizeKt.m712height3ABfNKs(modifier3, TabKt.SmallTabHeight), selected, interactionSource2, ripple, enabled3, Role.m5949boximpl(Role.INSTANCE.m5962getTabo7Vup1c()), function03), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function27 = function26;
                        Function2<Composer, Integer, Unit> function28 = function25;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
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
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i10 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                        function27.invoke($composer4, 0);
                        SpacerKt.Spacer(SizeKt.m723requiredWidth3ABfNKs(Modifier.INSTANCE, TabKt.TextDistanceFromLeadingIcon), $composer4, 6);
                        TextStyle style = TextStyle.m6159copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), $composer4, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6550getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                        TextKt.ProvideTextStyle(style, function28, $composer4, 0);
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
            }, $composer3, 54), $composer3, (($dirty >> 18) & 14) | 3072 | (($dirty >> 18) & 112) | (($dirty << 6) & 896));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unselectedContentColor4 = unselectedContentColor5;
            selectedContentColor3 = selectedContentColor2;
            modifier4 = modifier3;
            enabled4 = enabled3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
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

                public final void invoke(Composer composer, int i9) {
                    TabKt.m2595LeadingIconTabwqdebIU(selected, function0, function2, function22, modifier4, enabled4, selectedContentColor3, unselectedContentColor4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: Tab-bogVsAg, reason: not valid java name */
    public static final void m2596TabbogVsAg(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        Modifier modifier2;
        boolean enabled2;
        long selectedContentColor2;
        long unselectedContentColor2;
        int i2;
        int $dirty;
        final Modifier modifier3;
        long unselectedContentColor3;
        final MutableInteractionSource interactionSource2;
        int $dirty2;
        final boolean enabled3;
        long selectedContentColor3;
        int i3;
        Composer $composer2;
        final long selectedContentColor4;
        final long unselectedContentColor4;
        final Modifier modifier4;
        final MutableInteractionSource interactionSource3;
        final boolean enabled4;
        Composer $composer3 = $composer.startRestartGroup(-202735880);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)238@10306L7,246@10715L76,248@10867L600,248@10797L670:Tab.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
            z = selected;
        } else if (($changed & 6) == 0) {
            z = selected;
            $dirty3 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                selectedContentColor2 = selectedContentColor;
                int i6 = $composer3.changed(selectedContentColor2) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                selectedContentColor2 = selectedContentColor;
            }
            $dirty3 |= i6;
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                int i7 = $composer3.changed(unselectedContentColor2) ? 131072 : 65536;
                $dirty3 |= i7;
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            $dirty3 |= i7;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 8388608 : 4194304;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            enabled4 = enabled2;
            selectedContentColor4 = selectedContentColor2;
            interactionSource3 = interactionSource;
            long j = unselectedContentColor2;
            $composer2 = $composer3;
            unselectedContentColor4 = j;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    i2 = -458753;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor2 = ((Color) objConsume).m4197unboximpl();
                    $dirty = $dirty4 & (-57345);
                } else {
                    i2 = -458753;
                    $dirty = $dirty4;
                }
                if ((i & 32) != 0) {
                    $dirty &= i2;
                    unselectedContentColor2 = selectedContentColor2;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor2;
                    interactionSource2 = null;
                    $dirty2 = $dirty;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    i3 = -202735880;
                } else {
                    modifier3 = modifier2;
                    unselectedContentColor3 = unselectedContentColor2;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    i3 = -202735880;
                }
            } else {
                $composer3.skipToGroupEnd();
                $dirty2 = (i & 16) != 0 ? $dirty4 & (-57345) : $dirty4;
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                modifier3 = modifier2;
                unselectedContentColor3 = unselectedContentColor2;
                interactionSource2 = interactionSource;
                enabled3 = enabled2;
                selectedContentColor3 = selectedContentColor2;
                i3 = -202735880;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty2, -1, "androidx.compose.material3.Tab (Tab.kt:242)");
            }
            final Indication ripple = RippleKt.m2425rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, selectedContentColor3, $composer3, (($dirty2 >> 6) & 896) | 6, 2);
            final boolean z2 = z;
            m2598TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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
                    ComposerKt.sourceInformation($composer4, "C249@10877L584:Tab.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-551896140, $changed2, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m939selectableO2vRcR0(modifier3, z2, interactionSource2, ripple, enabled3, Role.m5949boximpl(Role.INSTANCE.m5962getTabo7Vup1c()), function0), 0.0f, 1, null);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Function3 content$iv = function3;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
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
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
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
            }, $composer3, 54), $composer3, (($dirty2 << 6) & 896) | (($dirty2 >> 12) & 14) | 3072 | (($dirty2 >> 12) & 112));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedContentColor4 = selectedContentColor3;
            unselectedContentColor4 = unselectedContentColor3;
            modifier4 = modifier3;
            interactionSource3 = interactionSource2;
            enabled4 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$4
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

                public final void invoke(Composer composer, int i9) {
                    TabKt.m2596TabbogVsAg(selected, function0, modifier4, enabled4, selectedContentColor4, unselectedContentColor4, interactionSource3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m2598TabTransitionKlgxPg(long activeColor, final long inactiveColor, final boolean selected, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        long j;
        long j2;
        boolean z;
        int $dirty;
        Object value$iv$iv;
        int $changed$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation($composer2, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            j = activeColor;
            $dirty2 |= $composer2.changed(j) ? 4 : 2;
        } else {
            j = activeColor;
        }
        if (($changed & 48) == 0) {
            j2 = inactiveColor;
            $dirty2 |= $composer2.changed(j2) ? 32 : 16;
        } else {
            j2 = inactiveColor;
        }
        if (($changed & 384) == 0) {
            z = selected;
            $dirty2 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = selected;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, $dirty2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
            }
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, $composer2, ($dirty2 >> 6) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer $composer3, int $changed2) {
                    TweenSpec tweenSpecTween$default;
                    $composer3.startReplaceGroup(-899623535);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-899623535, $changed2, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:284)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed2 = (0 >> 6) & 112;
            boolean it = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                $dirty = $dirty2;
                ComposerKt.traceEventStart(-1997025499, $changed2, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            } else {
                $dirty = $dirty2;
            }
            long j3 = it ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            ColorSpace colorSpace$iv = Color.m4191getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart($composer2, 1918408083, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(colorSpace$iv);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv2 = (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            int $changed3 = ($changed$iv$iv2 >> 9) & 112;
            boolean it2 = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                $changed$iv$iv = $changed$iv$iv2;
                ComposerKt.traceEventStart(-1997025499, $changed3, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            } else {
                $changed$iv$iv = $changed$iv$iv2;
            }
            long j4 = it2 ? j : inactiveColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv = Color.m4177boximpl(j4);
            int $changed4 = ($changed$iv$iv >> 9) & 112;
            boolean it3 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, $changed4, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j5 = it3 ? j : inactiveColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv = Color.m4177boximpl(j5);
            FiniteAnimationSpec<Color> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            State color$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv, "ColorAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(TabTransition_Klgx_Pg$lambda$2(color$delegate))), function2, $composer2, ProvidedValue.$stable | (($dirty >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j6 = j;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabTransition$1
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
                    TabKt.m2598TabTransitionKlgxPg(j6, inactiveColor, selected, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m4197unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0404  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TabBaselineLayout(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.TabBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        int contentY = (tabHeight - textOrIconPlaceable.getHeight()) / 2;
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, contentY, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float baselineOffset;
        if (firstBaseline == lastBaseline) {
            baselineOffset = SingleLineTextBaselineWithIcon;
        } else {
            baselineOffset = DoubleLineTextBaselineWithIcon;
        }
        int textOffset = density.mo361roundToPx0680j_4(baselineOffset) + density.mo361roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3475getActiveIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.mo360roundToPxR2X_6o(IconDistanceFromBaseline)) - firstBaseline;
        int textPlaceableX = (tabWidth - textPlaceable.getWidth()) / 2;
        int textPlaceableY = (tabHeight - lastBaseline) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, textPlaceableX, textPlaceableY, 0.0f, 4, null);
        int iconPlaceableX = (tabWidth - iconPlaceable.getWidth()) / 2;
        int iconPlaceableY = textPlaceableY - iconOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, iconPlaceableX, iconPlaceableY, 0.0f, 4, null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }
}
