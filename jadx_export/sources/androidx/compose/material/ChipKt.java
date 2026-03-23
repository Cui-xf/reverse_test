package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÆ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float HorizontalPadding = Dp.m6693constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m6693constructorimpl(4);
    private static final float LeadingIconEndSpacing = Dp.m6693constructorimpl(8);
    private static final float TrailingIconSpacing = Dp.m6693constructorimpl(8);
    private static final float SelectedIconContainerSize = Dp.m6693constructorimpl(24);

    public static final void Chip(final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, ChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        BorderStroke borderStroke;
        ChipColors chipColors;
        int i2;
        Function2 leadingIcon;
        CornerBasedShape shape3;
        int $dirty;
        Composer $composer2;
        ChipColors colors2;
        Shape shape4;
        int $dirty2;
        BorderStroke border2;
        boolean enabled3;
        MutableInteractionSource interactionSource3;
        Composer $composer3;
        final Modifier modifier3;
        final Function2 leadingIcon2;
        final boolean enabled4;
        final Shape shape5;
        final MutableInteractionSource interactionSource4;
        final ChipColors colors3;
        final BorderStroke border3;
        Composer $composer4 = $composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation($composer4, "C(Chip)P(7,6,3,4,8!2,5)93@4288L6,95@4405L12,99@4550L21,105@4747L24,109@4905L1458,100@4576L1787:Chip.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty3 |= $composer4.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer4.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            interactionSource2 = interactionSource;
        } else if (($changed & 3072) == 0) {
            interactionSource2 = interactionSource;
            $dirty3 |= $composer4.changed(interactionSource2) ? 2048 : 1024;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i6 = $composer4.changed(shape2) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i6;
        } else {
            shape2 = shape;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke = border;
        } else if ((196608 & $changed) == 0) {
            borderStroke = border;
            $dirty3 |= $composer4.changed(borderStroke) ? 131072 : 65536;
        } else {
            borderStroke = border;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                chipColors = colors;
                int i8 = $composer4.changed(chipColors) ? 1048576 : 524288;
                $dirty3 |= i8;
            } else {
                chipColors = colors;
            }
            $dirty3 |= i8;
        } else {
            chipColors = colors;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
            i2 = i7;
            leadingIcon = function2;
        } else if (($changed & 12582912) == 0) {
            i2 = i7;
            leadingIcon = function2;
            $dirty3 |= $composer4.changedInstance(leadingIcon) ? 8388608 : 4194304;
        } else {
            i2 = i7;
            leadingIcon = function2;
        }
        if ((i & 256) != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer4.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 38347923) == 38347922 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            $composer3 = $composer4;
            modifier3 = modifier2;
            enabled4 = enabled2;
            interactionSource4 = interactionSource2;
            shape5 = shape2;
            leadingIcon2 = leadingIcon;
            border3 = borderStroke;
            colors3 = chipColors;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    interactionSource2 = null;
                }
                if ((i & 16) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer4, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty = $dirty4 & (-57345);
                } else {
                    shape3 = shape2;
                    $dirty = $dirty4;
                }
                BorderStroke border4 = i2 != 0 ? null : borderStroke;
                if ((i & 64) != 0) {
                    colors2 = ChipDefaults.INSTANCE.m1477chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer4, 1572864, 63);
                    $composer2 = $composer4;
                    $dirty &= -3670017;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                }
                if (i9 != 0) {
                    shape4 = shape3;
                    leadingIcon = null;
                    $dirty2 = $dirty;
                    border2 = border4;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    leadingIcon = function2;
                    shape4 = shape3;
                    $dirty2 = $dirty;
                    border2 = border4;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty4 & (-3670017);
                    $composer2 = $composer4;
                    interactionSource3 = interactionSource2;
                    border2 = borderStroke;
                    colors2 = chipColors;
                    enabled3 = enabled2;
                    shape4 = shape2;
                } else {
                    $composer2 = $composer4;
                    interactionSource3 = interactionSource2;
                    border2 = borderStroke;
                    colors2 = chipColors;
                    $dirty2 = $dirty4;
                    enabled3 = enabled2;
                    shape4 = shape2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-368396408, $dirty2, -1, "androidx.compose.material.Chip (Chip.kt:98)");
            }
            final State contentColor$delegate = colors2.contentColor(enabled3, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 >> 15) & 112));
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                }
            }, 1, null);
            long jM4197unboximpl = colors2.backgroundColor(enabled3, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 >> 15) & 112)).getValue().m4197unboximpl();
            long jChip$lambda$0 = Chip$lambda$0(contentColor$delegate);
            final ChipColors colors4 = colors2;
            final Function2 leadingIcon3 = leadingIcon;
            final boolean enabled5 = enabled3;
            $composer3 = $composer2;
            SurfaceKt.m1677SurfaceLPr_se0(function02, modifierSemantics$default, enabled3, shape4, jM4197unboximpl, Color.m4185copywmQWz5c(jChip$lambda$0, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jChip$lambda$0) : 1.0f, (14 & 2) != 0 ? Color.m4193getRedimpl(jChip$lambda$0) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jChip$lambda$0) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jChip$lambda$0) : 0.0f), border2, 0.0f, interactionSource3, ComposableLambdaKt.rememberComposableLambda(139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2
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

                public final void invoke(Composer $composer5, int $changed2) {
                    ComposerKt.sourceInformation($composer5, "C110@4987L1370,110@4915L1442:Chip.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(139076687, $changed2, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4189getAlphaimpl(ChipKt.Chip$lambda$0(contentColor$delegate))));
                        final Function2<Composer, Integer, Unit> function22 = leadingIcon3;
                        final ChipColors chipColors2 = colors4;
                        final boolean z = enabled5;
                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1
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

                            public final void invoke(Composer $composer6, int $changed3) {
                                ComposerKt.sourceInformation($composer6, "C112@5057L10,113@5088L1259,111@5001L1346:Chip.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer6.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(667535631, $changed3, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer6, 6).getBody2();
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    final ChipColors chipColors3 = chipColors2;
                                    final boolean z2 = z;
                                    final Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(-1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
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

                                        public final void invoke(Composer $composer7, int $changed4) {
                                            float fM6693constructorimpl;
                                            Function0 factory$iv$iv$iv;
                                            ComposerKt.sourceInformation($composer7, "C114@5106L1227:Chip.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer7.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1131213696, $changed4, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                }
                                                Modifier modifierM711defaultMinSizeVpY3zN4$default = SizeKt.m711defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1480getMinHeightD9Ej5fM(), 1, null);
                                                if (function23 == null) {
                                                    fM6693constructorimpl = ChipKt.HorizontalPadding;
                                                } else {
                                                    fM6693constructorimpl = Dp.m6693constructorimpl(0);
                                                }
                                                Modifier modifier$iv = PaddingKt.m685paddingqDBjuR0$default(modifierM711defaultMinSizeVpY3zN4$default, fM6693constructorimpl, 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                ChipColors chipColors4 = chipColors3;
                                                boolean z3 = z2;
                                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                ComposerKt.sourceInformationMarkerStart($composer7, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                                int $changed$iv$iv = (432 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer7, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer7, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
                                                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer7, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!($composer7.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer7.startReusableNode();
                                                if ($composer7.getInserting()) {
                                                    factory$iv$iv$iv = factory$iv$iv$iv2;
                                                    $composer7.createNode(factory$iv$iv$iv);
                                                } else {
                                                    factory$iv$iv$iv = factory$iv$iv$iv2;
                                                    $composer7.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer7);
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                                                }
                                                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i10 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer7, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                                int $changed5 = ((432 >> 6) & 112) | 6;
                                                RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer7, 2027624470, "C138@6306L9:Chip.kt#jmzs0o");
                                                if (function24 != null) {
                                                    $composer7.startReplaceGroup(2027647564);
                                                    ComposerKt.sourceInformation($composer7, "129@5759L47,130@5869L32,131@5926L267,136@6218L45");
                                                    SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconStartSpacing), $composer7, 6);
                                                    State leadingIconContentColor$delegate = chipColors4.leadingIconContentColor(z3, $composer7, 0);
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor$delegate))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4189getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor$delegate))))}, function24, $composer7, ProvidedValue.$stable);
                                                    SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconEndSpacing), $composer7, 6);
                                                    $composer7.endReplaceGroup();
                                                } else {
                                                    $composer7.startReplaceGroup(2028178036);
                                                    $composer7.endReplaceGroup();
                                                }
                                                function34.invoke($this$invoke_u24lambda_u241, $composer7, Integer.valueOf($changed5 & 14));
                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                $composer7.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer7.skipToGroupEnd();
                                        }

                                        private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                            Object thisObj$iv = state.getValue();
                                            return ((Color) thisObj$iv).m4197unboximpl();
                                        }
                                    }, $composer6, 54), $composer6, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer6.skipToGroupEnd();
                            }
                        }, $composer5, 54), $composer5, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer2, 54), $composer3, ($dirty2 & 14) | 805306368 | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (3670016 & ($dirty2 << 3)) | (234881024 & ($dirty2 << 15)), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            leadingIcon2 = leadingIcon3;
            enabled4 = enabled3;
            shape5 = shape4;
            interactionSource4 = interactionSource3;
            colors3 = colors4;
            border3 = border2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3
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
                    ChipKt.Chip(function0, modifier3, enabled4, interactionSource4, shape5, border3, colors3, leadingIcon2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$0(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4197unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FilterChip(final boolean r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.ui.graphics.Shape r40, androidx.compose.foundation.BorderStroke r41, androidx.compose.material.SelectableChipColors r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.SelectableChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
