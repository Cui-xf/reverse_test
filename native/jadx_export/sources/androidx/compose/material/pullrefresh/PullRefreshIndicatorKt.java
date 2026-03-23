package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PullRefreshIndicator.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aJ\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a>\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float IndicatorSize = Dp.m6693constructorimpl(40);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m6693constructorimpl((float) 7.5d);
    private static final float StrokeWidth = Dp.m6693constructorimpl((float) 2.5d);
    private static final float ArrowWidth = Dp.m6693constructorimpl(10);
    private static final float ArrowHeight = Dp.m6693constructorimpl(5);
    private static final float Elevation = Dp.m6693constructorimpl(6);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m1750PullRefreshIndicatorjB83MbM(final boolean refreshing, final PullRefreshState state, Modifier modifier, long backgroundColor, long contentColor, boolean scale, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        boolean scale2;
        Modifier.Companion modifier3;
        long backgroundColor2;
        final long contentColor2;
        int i2;
        Object value$iv;
        long backgroundColor3;
        Composer $composer2;
        Color colorM4177boximpl;
        Function0 factory$iv$iv$iv;
        final long contentColor3;
        final long backgroundColor4;
        final Modifier modifier4;
        final boolean scale3;
        Composer $composer3 = $composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation($composer3, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)79@3427L6,80@3469L32,83@3559L98,90@3942L7,94@4070L1067:PullRefreshIndicator.kt#t44y28");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(refreshing) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(state) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j = backgroundColor;
                int i4 = $composer3.changed(j) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                j = backgroundColor;
            }
            $dirty |= i4;
        } else {
            j = backgroundColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                j2 = contentColor;
                int i5 = $composer3.changed(j2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                j2 = contentColor;
            }
            $dirty |= i5;
        } else {
            j2 = contentColor;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            scale2 = scale;
        } else if ((196608 & $changed) == 0) {
            scale2 = scale;
            $dirty |= $composer3.changed(scale2) ? 131072 : 65536;
        } else {
            scale2 = scale;
        }
        if ((74899 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            backgroundColor4 = j;
            contentColor3 = j2;
            scale3 = scale2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                    $dirty &= -7169;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                } else {
                    contentColor2 = j2;
                }
                if (i6 != 0) {
                    scale2 = false;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                backgroundColor2 = j;
                contentColor2 = j2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(308716636, $dirty, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1619083065, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | $composer3.changed(state);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                i2 = 0;
                value$iv = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(refreshing || state.getPosition$material_release() > 0.5f);
                    }
                });
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
                i2 = 0;
            }
            State showElevation$delegate = (State) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            if (elevationOverlay == null) {
                $composer3.startReplaceGroup(-1347612331);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
                backgroundColor3 = backgroundColor2;
                colorM4177boximpl = null;
            } else {
                $composer3.startReplaceGroup(1619096620);
                ComposerKt.sourceInformation($composer3, "91@3984L53");
                long backgroundColor5 = backgroundColor2;
                long backgroundColor6 = elevationOverlay.mo1536apply7g2Lkgo(backgroundColor5, Elevation, $composer3, (($dirty >> 9) & 14) | 48);
                backgroundColor3 = backgroundColor5;
                $composer2 = $composer3;
                $composer2.endReplaceGroup();
                colorM4177boximpl = Color.m4177boximpl(backgroundColor6);
            }
            long color = colorM4177boximpl != null ? colorM4177boximpl.m4197unboximpl() : backgroundColor3;
            Modifier modifier$iv = BackgroundKt.m229backgroundbw27NRU(ShadowKt.m3850shadows4CzXII$default(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.m726size3ABfNKs(modifier3, IndicatorSize), state, scale2), PullRefreshIndicator_jB83MbM$lambda$1(showElevation$delegate) ? Elevation : Dp.m6693constructorimpl(0), SpinnerShape, true, 0L, 0L, 24, null), color, SpinnerShape);
            int $changed$iv = i2;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            int $dirty2 = $dirty;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier3;
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
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i8 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1392970137, "C104@4488L643,101@4357L774:PullRefreshIndicator.kt#t44y28");
            CrossfadeKt.Crossfade(Boolean.valueOf(refreshing), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1853731063, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
                    invoke(bool.booleanValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean refreshing2, Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C105@4516L605:PullRefreshIndicator.kt#t44y28");
                    int $dirty3 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty3 |= $composer4.changed(refreshing2) ? 4 : 2;
                    }
                    if (($dirty3 & 19) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1853731063, $dirty3, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:105)");
                    }
                    Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                    long j3 = contentColor2;
                    PullRefreshState pullRefreshState = state;
                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(factory$iv$iv$iv3);
                    } else {
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer4);
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    int i10 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1566062036, "C:PullRefreshIndicator.kt#t44y28");
                    float arg0$iv = PullRefreshIndicatorKt.ArcRadius;
                    float other$iv = PullRefreshIndicatorKt.StrokeWidth;
                    float arg0$iv2 = Dp.m6693constructorimpl(arg0$iv + other$iv);
                    float arg0$iv3 = 2;
                    float spinnerSize = Dp.m6693constructorimpl(arg0$iv3 * arg0$iv2);
                    if (refreshing2) {
                        $composer4.startReplaceGroup(-1565983018);
                        ComposerKt.sourceInformation($composer4, "112@4764L208");
                        ProgressIndicatorKt.m1619CircularProgressIndicatorLxG7B9w(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, spinnerSize), j3, PullRefreshIndicatorKt.StrokeWidth, 0L, 0, $composer4, 390, 24);
                        $composer4.endReplaceGroup();
                    } else {
                        $composer4.startReplaceGroup(-1565735297);
                        ComposerKt.sourceInformation($composer4, "118@5018L71");
                        PullRefreshIndicatorKt.m1749CircularArrowIndicatoriJQMabo(pullRefreshState, j3, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, spinnerSize), $composer4, 384);
                        $composer4.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer$iv, 54), $composer$iv, ($dirty2 & 14) | 24960, 10);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor3 = contentColor2;
            backgroundColor4 = backgroundColor3;
            modifier4 = modifier5;
            scale3 = scale2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
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
                    PullRefreshIndicatorKt.m1750PullRefreshIndicatorjB83MbM(refreshing, state, modifier4, backgroundColor4, contentColor3, scale3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m1749CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        Object obj;
        Object objDerivedStateOf;
        Object obj2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)135@5348L61,137@5434L119,143@5576L74,146@5719L970,146@5689L1000:PullRefreshIndicator.kt#t44y28");
        int i2 = i;
        if ((i & 6) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(pullRefreshState) ? 4 : 2;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-486016981, i2, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:134)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -659480864, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo4080setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4476getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            } else {
                obj = objRememberedValue;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -659478054, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(pullRefreshState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objDerivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(pullRefreshState.getProgress() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objDerivedStateOf);
            } else {
                objDerivedStateOf = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$6((State) objDerivedStateOf), AlphaTween, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                }
            }, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -659468083, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(pullRefreshState) | composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) throws Throwable {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) throws Throwable {
                        long previousSize$iv$iv;
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
                        ArrowValues values = PullRefreshIndicatorKt.ArrowValues(pullRefreshState.getProgress());
                        float alpha = stateAnimateFloatAsState.getValue().floatValue();
                        float degrees$iv = values.getRotation();
                        long previousSize$iv$iv2 = j;
                        Path path2 = path;
                        long pivot$iv = $this$Canvas.mo4661getCenterF1C5BW0();
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$Canvas.getDrawContext();
                        long previousSize$iv$iv3 = $this$withTransform_u24lambda_u246$iv$iv2.mo4669getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
                        try {
                            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
                            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4675rotateUv8p0NA(degrees$iv, pivot$iv);
                            try {
                                float arcRadius = $this$Canvas.mo367toPx0680j_4(PullRefreshIndicatorKt.ArcRadius) + ($this$Canvas.mo367toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth) / 2.0f);
                                Rect arcBounds = new Rect(Offset.m3945getXimpl(androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$Canvas.mo4662getSizeNHjbRc())) - arcRadius, Offset.m3946getYimpl(androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$Canvas.mo4662getSizeNHjbRc())) - arcRadius, Offset.m3945getXimpl(androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$Canvas.mo4662getSizeNHjbRc())) + arcRadius, Offset.m3946getYimpl(androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$Canvas.mo4662getSizeNHjbRc())) + arcRadius);
                                previousSize$iv$iv = previousSize$iv$iv3;
                                try {
                                    try {
                                        DrawScope.CC.m4732drawArcyD3GUKo$default($this$Canvas, previousSize$iv$iv2, values.getStartAngle(), values.getEndAngle() - values.getStartAngle(), false, arcBounds.m3980getTopLeftF1C5BW0(), arcBounds.m3978getSizeNHjbRc(), alpha, new Stroke($this$Canvas.mo367toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth), 0.0f, StrokeCap.INSTANCE.m4549getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                                        previousSize$iv$iv = previousSize$iv$iv;
                                        $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                    } catch (Throwable th) {
                                        th = th;
                                        $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                        previousSize$iv$iv = previousSize$iv$iv;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                }
                                try {
                                    PullRefreshIndicatorKt.m1753drawArrowBx497Mc($this$Canvas, path2, arcBounds, previousSize$iv$iv2, alpha, values);
                                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                    $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                                } catch (Throwable th3) {
                                    th = th3;
                                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                    $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                previousSize$iv$iv = previousSize$iv$iv3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            previousSize$iv$iv = previousSize$iv$iv3;
                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierSemantics$default, (Function1) obj2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    PullRefreshIndicatorKt.m1749CircularArrowIndicatoriJQMabo(pullRefreshState, j, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5.0f) / 3.0f;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float $this$fastCoerceAtLeast$iv$iv = overshootPercent;
        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv > 2.0f) {
            $this$fastCoerceAtLeast$iv$iv = 2.0f;
        }
        float tensionPercent = $this$fastCoerceAtLeast$iv$iv - (((float) Math.pow($this$fastCoerceAtLeast$iv$iv, 2.0d)) / 4.0f);
        float endTrim = 0.8f * adjustedPercent;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float startAngle = rotation * 360.0f;
        float endAngle = (rotation + endTrim) * 360.0f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    public static final void m1753drawArrowBx497Mc(DrawScope $this$drawArrow_u2dBx497Mc, Path arrow, Rect bounds, long color, float alpha, ArrowValues values) throws Throwable {
        long previousSize$iv$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo($this$drawArrow_u2dBx497Mc.mo367toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        arrow.lineTo(($this$drawArrow_u2dBx497Mc.mo367toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f, $this$drawArrow_u2dBx497Mc.mo367toPx0680j_4(ArrowHeight) * values.getScale());
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2dBx497Mc.mo367toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo4082translatek4lQ0M(OffsetKt.Offset((Offset.m3945getXimpl(bounds.m3975getCenterF1C5BW0()) + radius) - inset, Offset.m3946getYimpl(bounds.m3975getCenterF1C5BW0()) + ($this$drawArrow_u2dBx497Mc.mo367toPx0680j_4(StrokeWidth) / 2.0f)));
        arrow.close();
        float degrees$iv = values.getEndAngle();
        long pivot$iv = $this$drawArrow_u2dBx497Mc.mo4661getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$drawArrow_u2dBx497Mc.getDrawContext();
        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4669getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4675rotateUv8p0NA(degrees$iv, pivot$iv);
            previousSize$iv$iv = previousSize$iv$iv2;
        } catch (Throwable th) {
            th = th;
            previousSize$iv$iv = previousSize$iv$iv2;
            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
        }
        try {
            DrawScope.CC.m4743drawPathLG529CI$default($this$drawArrow_u2dBx497Mc, arrow, color, alpha, null, null, 0, 56, null);
            $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv2.mo4670setSizeuvyYCjk(previousSize$iv$iv);
        } catch (Throwable th2) {
            th = th2;
            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
            throw th;
        }
    }
}
