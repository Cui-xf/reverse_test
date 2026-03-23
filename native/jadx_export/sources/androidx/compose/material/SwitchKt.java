package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aU\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a.\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0016\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float ThumbDefaultElevation;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float TrackWidth = Dp.m6693constructorimpl(34);
    private static final float TrackStrokeWidth = Dp.m6693constructorimpl(14);
    private static final float ThumbDiameter = Dp.m6693constructorimpl(20);
    private static final float ThumbRippleRadius = Dp.m6693constructorimpl(24);
    private static final float DefaultSwitchPadding = Dp.m6693constructorimpl(2);
    private static final float SwitchWidth = TrackWidth;
    private static final float SwitchHeight = ThumbDiameter;

    /* JADX WARN: Removed duplicated region for block: B:178:0x0583  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Switch(final boolean r43, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.material.SwitchColors r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope $this$SwitchImpl, final boolean checked, final boolean enabled, final SwitchColors colors, final Function0<Float> function0, final InteractionSource interactionSource, Composer $composer, final int $changed) {
        Object value$iv;
        SwitchKt$SwitchImpl$1$1 value$iv2;
        float f;
        Object value$iv3;
        String str;
        long jSwitchImpl$lambda$17;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation($composer2, "C(SwitchImpl)P(!1,2!1,4)221@9029L46,223@9115L614,223@9081L648,242@9932L28,246@10055L81,243@9965L171,249@10166L28,250@10244L7,*251@10303L7,253@10414L6,252@10353L228,262@10673L43,265@10826L133,259@10586L549:Switch.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$SwitchImpl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(checked) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, $dirty2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:220)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 463286824, "CC(remember):Switch.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList interactions = (SnapshotStateList) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 463290144, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SwitchKt$SwitchImpl$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, ($dirty2 >> 15) & 14);
            boolean hasInteraction = !interactions.isEmpty();
            if (hasInteraction) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float elevation = f;
            final State trackColor$delegate = colors.trackColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default($this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 463319691, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(trackColor$delegate);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        SwitchKt.m1690drawTrackRPmYEkk($this$Canvas, SwitchKt.SwitchImpl$lambda$15(trackColor$delegate), $this$Canvas.mo367toPx0680j_4(SwitchKt.getTrackWidth()), $this$Canvas.mo367toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) value$iv3, $composer2, 0);
            State thumbColor$delegate = colors.thumbColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((Dp) objConsume2).m6707unboximpl();
            float absoluteElevation = Dp.m6693constructorimpl(arg0$iv + elevation);
            if (Color.m4188equalsimpl0(SwitchImpl$lambda$17(thumbColor$delegate), MaterialTheme.INSTANCE.getColors($composer2, 6).m1498getSurface0d7_KjU()) && elevationOverlay != null) {
                $composer2.startReplaceGroup(1478408187);
                ComposerKt.sourceInformation($composer2, "254@10489L36");
                str = "CC(remember):Switch.kt#9igjgp";
                long jMo1536apply7g2Lkgo = elevationOverlay.mo1536apply7g2Lkgo(SwitchImpl$lambda$17(thumbColor$delegate), absoluteElevation, $composer2, 0);
                $composer2.endReplaceGroup();
                jSwitchImpl$lambda$17 = jMo1536apply7g2Lkgo;
            } else {
                str = "CC(remember):Switch.kt#9igjgp";
                $composer2.startReplaceGroup(1478489190);
                $composer2.endReplaceGroup();
                jSwitchImpl$lambda$17 = SwitchImpl$lambda$17(thumbColor$delegate);
            }
            State resolvedThumbColor$delegate = SingleValueAnimationKt.m108animateColorAsStateeuL9pac(jSwitchImpl$lambda$17, null, null, null, $composer2, 0, 14);
            $composer2 = $composer2;
            Modifier modifierAlign = $this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, 463339429, str);
            boolean invalid$iv3 = ($dirty2 & 57344) == 16384;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m6816boximpl(m1691invokeBjo55l4(density));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1691invokeBjo55l4(Density $this$offset) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(function0.invoke().floatValue()), 0);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(BackgroundKt.m229backgroundbw27NRU(ShadowKt.m3850shadows4CzXII$default(SizeKt.m718requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) value$iv4), interactionSource, RippleKt.m1646rippleOrFallbackImplementation9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$18(resolvedThumbColor$delegate), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    SwitchKt.SwitchImpl($this$SwitchImpl, checked, enabled, colors, function0, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$15(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4197unboximpl();
    }

    private static final long SwitchImpl$lambda$17(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4197unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4197unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1690drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / 2.0f;
        DrawScope.CC.m4739drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, androidx.compose.ui.geometry.OffsetKt.Offset(strokeRadius, Offset.m3946getYimpl($this$drawTrack_u2dRPmYEkk.mo4661getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(trackWidth - strokeRadius, Offset.m3946getYimpl($this$drawTrack_u2dRPmYEkk.mo4661getCenterF1C5BW0())), strokeWidth, StrokeCap.INSTANCE.m4548getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    static {
        float arg0$iv = TrackWidth;
        float other$iv = ThumbDiameter;
        ThumbPathLength = Dp.m6693constructorimpl(arg0$iv - other$iv);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m6693constructorimpl(1);
        ThumbPressedElevation = Dp.m6693constructorimpl(6);
        SwitchVelocityThreshold = Dp.m6693constructorimpl(125);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
