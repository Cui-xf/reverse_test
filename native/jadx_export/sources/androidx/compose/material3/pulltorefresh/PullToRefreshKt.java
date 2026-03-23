package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
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
import kotlin.ranges.RangesKt;

/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u001a(\u0010\u0017\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,H\u0007¢\u0006\u0002\u0010.\u001a\b\u0010/\u001a\u00020%H\u0007\u001a\r\u00100\u001a\u00020%H\u0007¢\u0006\u0002\u00101\u001aF\u00102\u001a\u00020\u0018*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a>\u0010=\u001a\u00020\u0018*\u0002032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001aH\u0010A\u001a\u00020#*\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aN\u0010F\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u001b2\b\b\u0002\u0010J\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshBox", "isRefreshing", "", "onRefresh", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "pullToRefresh", "enabled", "threshold", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "pullToRefreshIndicator", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "elevation", "pullToRefreshIndicator-wUdLESc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLandroidx/compose/ui/graphics/Shape;JF)Landroidx/compose/ui/Modifier;", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m6693constructorimpl((float) 2.5d);
    private static final float ArcRadius = Dp.m6693constructorimpl((float) 5.5d);
    private static final float SpinnerSize = Dp.m6693constructorimpl(16);
    private static final float SpinnerContainerSize = Dp.m6693constructorimpl(40);
    private static final float ArrowWidth = Dp.m6693constructorimpl(10);
    private static final float ArrowHeight = Dp.m6693constructorimpl(5);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getLinearEasing(), 2, null);

    public static final void PullToRefreshBox(final boolean isRefreshing, final Function0<Unit> function0, Modifier modifier, PullToRefreshState state, Alignment contentAlignment, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        final PullToRefreshState state2;
        Alignment contentAlignment2;
        Function3 indicator;
        Modifier.Companion modifier3;
        int $dirty;
        PullToRefreshState state3;
        Function0 factory$iv$iv$iv;
        final Modifier modifier4;
        final PullToRefreshState state4;
        final Alignment contentAlignment3;
        final Function3 indicator2;
        Composer $composer2 = $composer.startRestartGroup(1902956467);
        ComposerKt.sourceInformation($composer2, "C(PullToRefreshBox)P(3,5,4,6,1,2)124@5580L28,126@5713L163,135@5931L199:PullToRefresh.kt#djiw08");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(isRefreshing) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty2 |= $composer2.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                state2 = state;
                int i3 = $composer2.changed(state2) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                state2 = state;
            }
            $dirty2 |= i3;
        } else {
            state2 = state;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 24576) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty2 |= $composer2.changed(contentAlignment2) ? 16384 : 8192;
        } else {
            contentAlignment2 = contentAlignment;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            indicator = function3;
        } else if ((196608 & $changed) == 0) {
            indicator = function3;
            $dirty2 |= $composer2.changedInstance(indicator) ? 131072 : 65536;
        } else {
            indicator = function3;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function32) ? 1048576 : 524288;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            state4 = state2;
            contentAlignment3 = contentAlignment2;
            indicator2 = indicator;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    state2 = rememberPullToRefreshState($composer2, 0);
                }
                if (i4 != 0) {
                    contentAlignment2 = Alignment.INSTANCE.getTopStart();
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    indicator = ComposableLambdaKt.rememberComposableLambda(1989171225, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                            invoke(boxScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxScope $this$null, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C127@5723L147:PullToRefresh.kt#djiw08");
                            int $dirty3 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty3 |= $composer3.changed($this$null) ? 4 : 2;
                            }
                            int $dirty4 = $dirty3;
                            if (($dirty4 & 19) == 18 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1989171225, $dirty4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox.<anonymous> (PullToRefresh.kt:127)");
                            }
                            PullToRefreshDefaults.INSTANCE.m3001Indicator2poqoh4(state2, isRefreshing, $this$null.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0L, 0L, 0.0f, $composer3, 1572864, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                    state3 = state2;
                } else {
                    $dirty = $dirty2;
                    state3 = state2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                state3 = state2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1902956467, $dirty, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:134)");
            }
            Modifier modifier5 = modifier3;
            Modifier modifier$iv = m3015pullToRefreshZ4HSEVQ$default(modifier5, isRefreshing, state3, false, 0.0f, function02, 12, null);
            int $changed$iv = ($dirty >> 9) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment2, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            PullToRefreshState state5 = state3;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int $changed2 = (($changed$iv >> 6) & 112) | 6;
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1101976897, "C139@6095L9,140@6113L11:PullToRefresh.kt#djiw08");
            function32.invoke(boxScopeInstance, $composer2, Integer.valueOf(($changed2 & 14) | (($dirty >> 15) & 112)));
            indicator.invoke(boxScopeInstance, $composer2, Integer.valueOf(($changed2 & 14) | (($dirty >> 12) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            state4 = state5;
            contentAlignment3 = contentAlignment2;
            indicator2 = indicator;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox.3
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
                    PullToRefreshKt.PullToRefreshBox(isRefreshing, function0, modifier4, state4, contentAlignment3, indicator2, function32, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc, reason: not valid java name */
    public static final Modifier m3016pullToRefreshIndicatorwUdLESc(Modifier $this$pullToRefreshIndicator_u2dwUdLESc, final PullToRefreshState state, final boolean isRefreshing, final float threshold, final Shape shape, long containerColor, final float elevation) {
        return BackgroundKt.m229backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(SizeKt.m726size3ABfNKs($this$pullToRefreshIndicator_u2dwUdLESc, SpinnerContainerSize), new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                ContentDrawScope $this$clipRect_u2drOu3jXo_u24default$iv = $this$drawWithContent;
                int clipOp$iv = ClipOp.INSTANCE.m4176getIntersectrtfAjoo();
                DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4669getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                try {
                    DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                    $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4672clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, clipOp$iv);
                    $this$drawWithContent.drawContent();
                } finally {
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                }
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$2
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
                boolean showElevation = state.getDistanceFraction() > 0.0f || isRefreshing;
                $this$graphicsLayer.setTranslationY((state.getDistanceFraction() * $this$graphicsLayer.mo361roundToPx0680j_4(threshold)) - Size.m4011getHeightimpl($this$graphicsLayer.getSize()));
                $this$graphicsLayer.setShadowElevation(showElevation ? $this$graphicsLayer.mo367toPx0680j_4(elevation) : 0.0f);
                $this$graphicsLayer.setShape(shape);
                $this$graphicsLayer.setClip(true);
            }
        }), containerColor, shape);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3015pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0 function0, int i, Object obj) {
        float fM3003getPositionalThresholdD9Ej5fM;
        boolean z3 = (i & 4) != 0 ? true : z2;
        if ((i & 8) == 0) {
            fM3003getPositionalThresholdD9Ej5fM = f;
        } else {
            fM3003getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m3003getPositionalThresholdD9Ej5fM();
        }
        return m3014pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, fM3003getPositionalThresholdD9Ej5fM, function0);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m3014pullToRefreshZ4HSEVQ(Modifier $this$pullToRefresh_u2dZ4HSEVQ, boolean isRefreshing, PullToRefreshState state, boolean enabled, float threshold, Function0<Unit> function0) {
        return $this$pullToRefresh_u2dZ4HSEVQ.then(new PullToRefreshElement(isRefreshing, function0, enabled, state, threshold, null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 318623070, "C(rememberPullToRefreshState)513@19156L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, $changed, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m3772rememberSaveable(new Object[0], (Saver) PullToRefreshStateImpl.INSTANCE.getSaver(), (String) null, (Function0) new Function0<PullToRefreshStateImpl>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.rememberPullToRefreshState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PullToRefreshStateImpl invoke() {
                return new PullToRefreshStateImpl();
            }
        }, $composer, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return pullToRefreshStateImpl;
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m3008CircularArrowProgressIndicatorRPmYEkk(final Function0<Float> function0, final long j, Composer composer, final int i) {
        Object obj;
        Object objDerivedStateOf;
        Object obj2;
        Object obj3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)562@20583L61,564@20745L76,565@20843L74,567@20982L98,571@21118L443,566@20922L639:PullToRefresh.kt#djiw08");
        int i2 = i;
        if ((i & 6) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1136642763, "CC(remember):PullToRefresh.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1136647962, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objDerivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(function0.invoke().floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objDerivedStateOf);
            } else {
                objDerivedStateOf = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$4((State) objDerivedStateOf), AlphaTween, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1136655568, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo($this$semantics, new ProgressBarRangeInfo(function0.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM726size3ABfNKs = SizeKt.m726size3ABfNKs(SemanticsModifierKt.semantics(companion, true, (Function1) obj2), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1136660265, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean zChanged = ((i3 & 14) == 4) | composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                obj3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
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
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
                        long previousSize$iv$iv;
                        Rect arcBounds;
                        ArrowValues values = PullToRefreshKt.ArrowValues(function0.invoke().floatValue());
                        float alpha = stateAnimateFloatAsState.getValue().floatValue();
                        float degrees$iv = values.getRotation();
                        long j2 = j;
                        Path path2 = path;
                        long pivot$iv = $this$Canvas.mo4661getCenterF1C5BW0();
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$Canvas.getDrawContext();
                        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4669getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
                        try {
                            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
                            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4675rotateUv8p0NA(degrees$iv, pivot$iv);
                            float arcRadius = $this$Canvas.mo367toPx0680j_4(PullToRefreshKt.ArcRadius) + ($this$Canvas.mo367toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f);
                            arcBounds = RectKt.m3984Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$Canvas.mo4662getSizeNHjbRc()), arcRadius);
                            try {
                                previousSize$iv$iv = previousSize$iv$iv2;
                                try {
                                    PullToRefreshKt.m3013drawCircularIndicatorKzyDr3Q($this$Canvas, j2, alpha, values, arcBounds, PullToRefreshKt.StrokeWidth);
                                    $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                    try {
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                previousSize$iv$iv = previousSize$iv$iv2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                            previousSize$iv$iv = previousSize$iv$iv2;
                        }
                        try {
                            PullToRefreshKt.m3012drawArrowuDrxG_w($this$Canvas, path2, arcBounds, j2, alpha, values, PullToRefreshKt.StrokeWidth);
                            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                        } catch (Throwable th5) {
                            th = th5;
                            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                            throw th;
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj3);
            } else {
                obj3 = objRememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM726size3ABfNKs, (Function1) obj3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    PullToRefreshKt.m3008CircularArrowProgressIndicatorRPmYEkk(function0, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    public static final void m3013drawCircularIndicatorKzyDr3Q(DrawScope $this$drawCircularIndicator_u2dKzyDr3Q, long color, float alpha, ArrowValues values, Rect arcBounds, float strokeWidth) {
        DrawScope.CC.m4732drawArcyD3GUKo$default($this$drawCircularIndicator_u2dKzyDr3Q, color, values.getStartAngle(), values.getEndAngle() - values.getStartAngle(), false, arcBounds.m3980getTopLeftF1C5BW0(), arcBounds.m3978getSizeNHjbRc(), alpha, new Stroke($this$drawCircularIndicator_u2dKzyDr3Q.mo367toPx0680j_4(strokeWidth), 0.0f, StrokeCap.INSTANCE.m4547getButtKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5.0f) / 3.0f;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
        float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2.0d)) / 4.0f);
        float endTrim = 0.8f * adjustedPercent;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float startAngle = rotation * 360.0f;
        float endAngle = (rotation + endTrim) * 360.0f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m3012drawArrowuDrxG_w(DrawScope $this$drawArrow_u2duDrxG_w, Path arrow, Rect bounds, long color, float alpha, ArrowValues values, float strokeWidth) throws Throwable {
        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
        long previousSize$iv$iv;
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo(($this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f, $this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(ArrowHeight) * values.getScale());
        arrow.lineTo($this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo4082translatek4lQ0M(OffsetKt.Offset((Offset.m3945getXimpl(bounds.m3975getCenterF1C5BW0()) + radius) - inset, Offset.m3946getYimpl(bounds.m3975getCenterF1C5BW0()) - $this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(strokeWidth)));
        float degrees$iv = values.getEndAngle() - $this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(strokeWidth);
        long pivot$iv = $this$drawArrow_u2duDrxG_w.mo4661getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$drawArrow_u2duDrxG_w.getDrawContext();
        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4669getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4675rotateUv8p0NA(degrees$iv, pivot$iv);
            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
            try {
                previousSize$iv$iv = previousSize$iv$iv2;
                try {
                    DrawScope.CC.m4743drawPathLG529CI$default($this$drawArrow_u2duDrxG_w, arrow, color, alpha, new Stroke($this$drawArrow_u2duDrxG_w.mo367toPx0680j_4(strokeWidth), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                } catch (Throwable th) {
                    th = th;
                    $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv;
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                previousSize$iv$iv = previousSize$iv$iv2;
            }
        } catch (Throwable th3) {
            th = th3;
            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
            previousSize$iv$iv = previousSize$iv$iv2;
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }
}
