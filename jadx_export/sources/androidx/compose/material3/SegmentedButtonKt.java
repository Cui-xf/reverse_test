package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SegmentedButton.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0091\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u008b\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = Dp.m6693constructorimpl(8);

    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean checked, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        int i2;
        int i3;
        Modifier modifier3;
        SegmentedButtonColors colors3;
        boolean enabled3;
        MutableInteractionSource interactionSource2;
        int $dirty;
        BorderStroke border3;
        final Function2 icon;
        MutableInteractionSource interactionSource3;
        Composer $composer2;
        int $dirty2;
        final boolean enabled4;
        final BorderStroke border4;
        final Modifier modifier4;
        final SegmentedButtonColors colors4;
        final Function2 icon2;
        final MutableInteractionSource interactionSource4;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(-1596038053);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButton)P(1,8,9,7,3,2!1,5)133@6692L8,137@6905L41,144@7279L25,163@7880L51,146@7310L621:SegmentedButton.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(checked) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enabled2 = enabled;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 64) == 0) {
                border2 = border;
                int i7 = $composer3.changed(border2) ? 8388608 : 4194304;
                $dirty3 |= i7;
            } else {
                border2 = border;
            }
            $dirty3 |= i7;
        } else {
            border2 = border;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 100663296;
            i2 = i8;
        } else if (($changed & 100663296) == 0) {
            i2 = i8;
            $dirty3 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i8;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 805306368;
            i3 = i9;
        } else if (($changed & 805306368) == 0) {
            i3 = i9;
            $dirty3 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            i3 = i9;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource4 = interactionSource;
            $composer2 = $composer3;
            $dirty2 = $dirty3;
            enabled4 = enabled2;
            border4 = border2;
            icon2 = function2;
            colors4 = colors2;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer3, 6);
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2468borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2452borderColorWaAFU9c$material3_release(enabled2, checked), 0.0f, 2, null);
                    $dirty3 &= -29360129;
                }
                MutableInteractionSource interactionSource5 = i2 != 0 ? null : interactionSource;
                if (i3 != 0) {
                    Modifier modifier6 = modifier5;
                    int i10 = $dirty3;
                    icon = ComposableLambdaKt.rememberComposableLambda(970447394, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.1
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
                            ComposerKt.sourceInformation($composer4, "C137@6931L13:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(970447394, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:137)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(checked, null, null, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                    colors3 = colors2;
                    enabled3 = enabled2;
                    $dirty = i10;
                    modifier3 = modifier6;
                    interactionSource2 = interactionSource5;
                    border3 = border2;
                } else {
                    modifier3 = modifier5;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty3;
                    border3 = border2;
                    icon = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i11 = $dirty3 & (-29360129);
                    boolean z = enabled2;
                    $dirty = i11;
                    colors3 = colors2;
                    enabled3 = z;
                    interactionSource2 = interactionSource;
                    icon = function2;
                    border3 = border2;
                    modifier3 = modifier2;
                } else {
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier3 = modifier2;
                    $dirty = $dirty3;
                    icon = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1596038053, $dirty, $dirty12, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:139)");
            }
            $composer3.startReplaceGroup(1788099965);
            ComposerKt.sourceInformation($composer3, "141@7068L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1788100616, "CC(remember):SegmentedButton.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                interactionSource3 = (MutableInteractionSource) value$iv;
            } else {
                interactionSource3 = interactionSource2;
            }
            $composer3.endReplaceGroup();
            long containerColor = colors3.m2453containerColorWaAFU9c$material3_release(enabled3, checked);
            int $dirty4 = $dirty;
            long contentColor = colors3.m2454contentColorWaAFU9c$material3_release(enabled3, checked);
            State interactionCount = interactionCountAsState(interactionSource3, $composer3, 0);
            Modifier modifier7 = modifier3;
            SegmentedButtonColors colors5 = colors3;
            $composer2 = $composer3;
            Function2 icon3 = icon;
            SurfaceKt.m2563Surfaced85dljk(checked, function1, SizeKt.m710defaultMinSizeVpY3zN4(interactionZIndex(RowScope.CC.weight$default($this$SegmentedButton, modifier3, 1.0f, false, 2, null), checked, interactionCount), ButtonDefaults.INSTANCE.m1836getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1835getMinHeightD9Ej5fM()), enabled3, shape, containerColor, contentColor, 0.0f, 0.0f, border3, interactionSource3, ComposableLambdaKt.rememberComposableLambda(1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.2
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
                    ComposerKt.sourceInformation($composer4, "C164@7890L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1635710341, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:164)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(icon, function22, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty4 >> 3) & 14) | (($dirty4 >> 3) & 112) | (($dirty4 >> 6) & 7168) | (57344 & ($dirty4 << 3)) | (($dirty4 << 6) & 1879048192), 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty2 = $dirty4;
            enabled4 = enabled3;
            border4 = border3;
            modifier4 = modifier7;
            colors4 = colors5;
            icon2 = icon3;
            interactionSource4 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.3
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
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, checked, function1, shape, modifier4, enabled4, colors4, border4, interactionSource4, icon2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean selected, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        int i2;
        int i3;
        Modifier modifier3;
        SegmentedButtonColors colors3;
        boolean enabled3;
        MutableInteractionSource interactionSource2;
        int $dirty;
        BorderStroke border3;
        final Function2 icon;
        MutableInteractionSource interactionSource3;
        Composer $composer2;
        int $dirty2;
        final boolean enabled4;
        final BorderStroke border4;
        final Modifier modifier4;
        final SegmentedButtonColors colors4;
        final MutableInteractionSource interactionSource4;
        final Function2 icon2;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(-1016574361);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButton)P(8,7,9,6,2,1!1,4)211@10255L8,215@10469L42,222@10846L25,242@11489L51,224@10877L663:SegmentedButton.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enabled2 = enabled;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 64) == 0) {
                border2 = border;
                int i7 = $composer3.changed(border2) ? 8388608 : 4194304;
                $dirty3 |= i7;
            } else {
                border2 = border;
            }
            $dirty3 |= i7;
        } else {
            border2 = border;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 100663296;
            i2 = i8;
        } else if (($changed & 100663296) == 0) {
            i2 = i8;
            $dirty3 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i8;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 805306368;
            i3 = i9;
        } else if (($changed & 805306368) == 0) {
            i3 = i9;
            $dirty3 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            i3 = i9;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource4 = interactionSource;
            $composer2 = $composer3;
            $dirty2 = $dirty3;
            enabled4 = enabled2;
            border4 = border2;
            icon2 = function2;
            colors4 = colors2;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer3, 6);
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2468borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2452borderColorWaAFU9c$material3_release(enabled2, selected), 0.0f, 2, null);
                    $dirty3 &= -29360129;
                }
                MutableInteractionSource interactionSource5 = i2 != 0 ? null : interactionSource;
                if (i3 != 0) {
                    Modifier modifier6 = modifier5;
                    int i10 = $dirty3;
                    icon = ComposableLambdaKt.rememberComposableLambda(1235063168, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.4
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
                            ComposerKt.sourceInformation($composer4, "C215@10495L14:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1235063168, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:215)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(selected, null, null, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                    colors3 = colors2;
                    enabled3 = enabled2;
                    $dirty = i10;
                    modifier3 = modifier6;
                    interactionSource2 = interactionSource5;
                    border3 = border2;
                } else {
                    modifier3 = modifier5;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty3;
                    border3 = border2;
                    icon = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i11 = $dirty3 & (-29360129);
                    boolean z = enabled2;
                    $dirty = i11;
                    colors3 = colors2;
                    enabled3 = z;
                    interactionSource2 = interactionSource;
                    icon = function2;
                    border3 = border2;
                    modifier3 = modifier2;
                } else {
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier3 = modifier2;
                    $dirty = $dirty3;
                    icon = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016574361, $dirty, $dirty12, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:217)");
            }
            $composer3.startReplaceGroup(1788214045);
            ComposerKt.sourceInformation($composer3, "219@10633L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1788214696, "CC(remember):SegmentedButton.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                interactionSource3 = (MutableInteractionSource) value$iv;
            } else {
                interactionSource3 = interactionSource2;
            }
            $composer3.endReplaceGroup();
            long containerColor = colors3.m2453containerColorWaAFU9c$material3_release(enabled3, selected);
            int $dirty4 = $dirty;
            long contentColor = colors3.m2454contentColorWaAFU9c$material3_release(enabled3, selected);
            State interactionCount = interactionCountAsState(interactionSource3, $composer3, 0);
            Modifier modifier7 = modifier3;
            SegmentedButtonColors colors5 = colors3;
            $composer2 = $composer3;
            Function2 icon3 = icon;
            SurfaceKt.m2562Surfaced85dljk(selected, function0, SemanticsModifierKt.semantics$default(SizeKt.m710defaultMinSizeVpY3zN4(interactionZIndex(RowScope.CC.weight$default($this$SegmentedButton, modifier3, 1.0f, false, 2, null), selected, interactionCount), ButtonDefaults.INSTANCE.m1836getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1835getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5960getRadioButtono7Vup1c());
                }
            }, 1, null), enabled3, shape, containerColor, contentColor, 0.0f, 0.0f, border3, interactionSource3, ComposableLambdaKt.rememberComposableLambda(383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.6
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
                    ComposerKt.sourceInformation($composer4, "C243@11499L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(383378045, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:243)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(icon, function22, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty4 >> 3) & 14) | (($dirty4 >> 3) & 112) | (($dirty4 >> 6) & 7168) | (57344 & ($dirty4 << 3)) | (($dirty4 << 6) & 1879048192), 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty2 = $dirty4;
            enabled4 = enabled3;
            border4 = border3;
            modifier4 = modifier7;
            colors4 = colors5;
            interactionSource4 = interactionSource2;
            icon2 = icon3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.7
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
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, selected, function0, shape, modifier4, enabled4, colors4, border4, interactionSource4, icon2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2474SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float space, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        Function0 factory$iv$iv$iv;
        final Modifier modifier3;
        final float space2;
        Composer $composer2 = $composer.startRestartGroup(-1520863498);
        ComposerKt.sourceInformation($composer2, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)269@12565L447:SegmentedButton.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = space;
        } else if (($changed & 48) == 0) {
            f = space;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = space;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            space2 = f;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            float space3 = i3 != 0 ? SegmentedButtonDefaults.INSTANCE.m2471getBorderWidthD9Ej5fM() : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, $dirty2, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:268)");
            }
            Modifier modifier$iv = IntrinsicKt.width(SizeKt.m711defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier4), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3374getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m557spacedBy0680j_4(Dp.m6693constructorimpl(-space3));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            float space4 = space3;
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
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SingleChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1586778660, "C278@12924L58,279@12997L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart($composer2, -1334286565, "CC(remember):SegmentedButton.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SingleChoiceSegmentedButtonScopeWrapper($this$SingleChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u243);
                $composer2.updateRememberedValue(value$iv);
            }
            SingleChoiceSegmentedButtonScopeWrapper scope = (SingleChoiceSegmentedButtonScopeWrapper) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            function3.invoke(scope, $composer2, Integer.valueOf((($dirty2 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            space2 = space4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2474SingleChoiceSegmentedButtonRowuFdPcIQ(modifier3, space2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2473MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float space, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        Function0 factory$iv$iv$iv;
        final Modifier modifier3;
        final float space2;
        Composer $composer2 = $composer.startRestartGroup(155922315);
        ComposerKt.sourceInformation($composer2, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)307@14058L411:SegmentedButton.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = space;
        } else if (($changed & 48) == 0) {
            f = space;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = space;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            space2 = f;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            float space3 = i3 != 0 ? SegmentedButtonDefaults.INSTANCE.m2471getBorderWidthD9Ej5fM() : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, $dirty2, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:306)");
            }
            Modifier modifier$iv = IntrinsicKt.width(SizeKt.m711defaultMinSizeVpY3zN4$default(modifier4, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3374getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m557spacedBy0680j_4(Dp.m6693constructorimpl(-space3));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            float space4 = space3;
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
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$MultiChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1297400858, "C315@14382L57,316@14454L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart($composer2, 596041317, "CC(remember):SegmentedButton.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MultiChoiceSegmentedButtonScopeWrapper($this$MultiChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u245);
                $composer2.updateRememberedValue(value$iv);
            }
            MultiChoiceSegmentedButtonScopeWrapper scope = (MultiChoiceSegmentedButtonScopeWrapper) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            function3.invoke(scope, $composer2, Integer.valueOf((($dirty2 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            space2 = space4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2473MultiChoiceSegmentedButtonRowuFdPcIQ(modifier3, space2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButtonContent)P(1)325@14600L595:SegmentedButton.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, $dirty, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:324)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierPadding);
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1425737070, "C329@14804L5,330@14847L342,330@14818L371:SegmentedButton.kt#uh7d8r");
            TextStyle typography = TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), $composer2, 6);
            TextKt.ProvideTextStyle(typography, ComposableLambdaKt.rememberComposableLambda(1420592651, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
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
                    Object value$iv$iv2;
                    ComposerKt.sourceInformation($composer4, "C331@14873L24,332@14930L55,334@14999L180:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1420592651, $changed2, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:331)");
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
                        CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1708740237, "CC(remember):SegmentedButton.kt#9igjgp");
                        Object it$iv = $composer4.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new SegmentedButtonContentMeasurePolicy(scope);
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        SegmentedButtonContentMeasurePolicy measurePolicy = (SegmentedButtonContentMeasurePolicy) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                        boolean invalid$iv$iv = true;
                        List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function22});
                        ComposerKt.sourceInformationMarkerStart($composer4, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(listListOf);
                        ComposerKt.sourceInformationMarkerStart($composer4, -290761997, "CC(remember):Layout.kt#9igjgp");
                        if ((((432 & 896) ^ 384) <= 256 || !$composer4.changed(measurePolicy)) && (432 & 384) != 256) {
                            invalid$iv$iv = false;
                        }
                        Object it$iv$iv2 = $composer4.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
                            $composer4.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int $changed$iv$iv2 = 432 & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifierHeight);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        content$iv$iv.invoke($composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 6) & 14));
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
            }, $composer2, 54), $composer2, 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButtonContent.2
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
                    SegmentedButtonKt.SegmentedButtonContent(function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource $this$interactionCountAsState, Composer $composer, int $changed) {
        Object value$iv;
        SegmentedButtonKt$interactionCountAsState$1$1 value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 281890131, "C(interactionCountAsState)397@17381L33,398@17440L499,398@17419L520:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, $changed, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:396)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 408875648, "CC(remember):SegmentedButton.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableIntState interactionCount = (MutableIntState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 408878002, "CC(remember):SegmentedButton.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed($this$interactionCountAsState)) || ($changed & 6) == 4;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new SegmentedButtonKt$interactionCountAsState$1$1($this$interactionCountAsState, interactionCount, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($this$interactionCountAsState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return interactionCount;
    }

    private static final Modifier interactionZIndex(Modifier $this$interactionZIndex, final boolean checked, final State<Integer> state) {
        return LayoutModifierKt.layout($this$interactionZIndex, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2475invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2475invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                final Placeable placeable = measurable.mo5535measureBRTryo0(constraints);
                int width = placeable.getWidth();
                int height = placeable.getHeight();
                final State<Integer> state2 = state;
                final boolean z = checked;
                return MeasureScope.CC.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1.1
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
                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                        float zIndex = state2.getValue().floatValue() + (z ? SegmentedButtonKt.CheckedZIndexFactor : 0.0f);
                        $this$layout2.place(placeable, 0, 0, zIndex);
                    }
                }, 4, null);
            }
        });
    }
}
