package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tooltip.android.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"PlainTooltip", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-7QI4Sbk", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-yDvdmqw", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-JKu-mZY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JJLandroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Tooltip_androidKt {
    /* renamed from: PlainTooltip-7QI4Sbk, reason: not valid java name */
    public static final void m2862PlainTooltip7QI4Sbk(final TooltipScope $this$PlainTooltip_u2d7QI4Sbk, Modifier modifier, long caretSize, Shape shape, long contentColor, long containerColor, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        final long contentColor2;
        long containerColor2;
        float tonalElevation2;
        long caretSize2;
        float shadowElevation2;
        int $dirty;
        float tonalElevation3;
        long caretSize3;
        Shape shape3;
        int $dirty2;
        long containerColor3;
        long containerColor4;
        Modifier drawCaretModifier;
        Composer $composer2;
        int $dirty3;
        final Modifier modifier3;
        final long caretSize4;
        final long contentColor3;
        final Shape shape4;
        final long containerColor5;
        final float tonalElevation4;
        final float shadowElevation3;
        final long caretSize5;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(1407069716);
        ComposerKt.sourceInformation($composer3, "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= ($changed & 8) == 0 ? $composer3.changed($this$PlainTooltip_u2d7QI4Sbk) : $composer3.changedInstance($this$PlainTooltip_u2d7QI4Sbk) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty4 |= ((i & 2) == 0 && $composer3.changed(caretSize)) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i3 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty4 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty4 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty4 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 16) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 131072 : 65536;
                $dirty4 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty4 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= 1572864;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 1572864) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty4 |= $composer3.changed(tonalElevation2) ? 1048576 : 524288;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty4 |= $composer3.changed(shadowElevation) ? 8388608 : 4194304;
        }
        if ((i & 128) != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty4) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            shape4 = shape2;
            containerColor5 = containerColor2;
            contentColor3 = contentColor2;
            tonalElevation4 = tonalElevation2;
            shadowElevation3 = shadowElevation;
            $dirty3 = $dirty4;
            caretSize4 = caretSize;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    caretSize2 = DpSize.INSTANCE.m6800getUnspecifiedMYxV2XQ();
                    $dirty4 &= -897;
                } else {
                    caretSize2 = caretSize;
                }
                if ((i & 4) != 0) {
                    $dirty4 &= -7169;
                    shape2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape($composer3, 6);
                }
                if ((i & 8) != 0) {
                    contentColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor($composer3, 6);
                    $dirty4 &= -57345;
                }
                if ((i & 16) != 0) {
                    containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor($composer3, 6);
                    $dirty4 &= -458753;
                }
                if (i6 != 0) {
                    tonalElevation2 = Dp.m6693constructorimpl(0);
                }
                if (i7 != 0) {
                    shadowElevation2 = Dp.m6693constructorimpl(0);
                    $dirty = $dirty4;
                    tonalElevation3 = tonalElevation2;
                    caretSize3 = caretSize2;
                } else {
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty4;
                    tonalElevation3 = tonalElevation2;
                    caretSize3 = caretSize2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 4) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 8) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty4 & (-458753);
                    caretSize3 = caretSize;
                    shadowElevation2 = shadowElevation;
                    tonalElevation3 = tonalElevation2;
                } else {
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty4;
                    tonalElevation3 = tonalElevation2;
                    caretSize3 = caretSize;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                shape3 = shape2;
                ComposerKt.traceEventStart(1407069716, $dirty, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)");
            } else {
                shape3 = shape2;
            }
            $composer3.startReplaceGroup(-333850415);
            ComposerKt.sourceInformation($composer3, "76@3183L7,77@3242L7,78@3281L343");
            long $this$isSpecified$iv = caretSize3;
            if (($this$isSpecified$iv != InlineClassHelperKt.UnspecifiedPackedFloats ? 1 : 0) != 0) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Density density = (Density) objConsume;
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Configuration configuration = (Configuration) objConsume2;
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -333845325, "CC(remember):Tooltip.android.kt#9igjgp");
                boolean invalid$iv = ((((458752 & $dirty) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && $composer3.changed(containerColor2)) || ($dirty & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | $composer3.changed(density) | $composer3.changedInstance(configuration) | (((($dirty & 896) ^ 384) > 256 && $composer3.changed(caretSize3)) || ($dirty & 384) == 256);
                $dirty2 = $dirty;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                    caretSize5 = caretSize3;
                } else {
                    caretSize5 = caretSize3;
                    if (it$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv = it$iv;
                        containerColor3 = containerColor2;
                        containerColor4 = caretSize5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    drawCaretModifier = $this$PlainTooltip_u2d7QI4Sbk.drawCaret(companion, (Function2) value$iv).then(modifier2);
                }
                final long containerColor6 = containerColor2;
                containerColor3 = containerColor6;
                containerColor4 = caretSize5;
                value$iv = (Function2) new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$drawCaretModifier$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final DrawResult invoke(CacheDrawScope $this$drawCaret, LayoutCoordinates anchorLayoutCoordinates) {
                        return Tooltip_androidKt.m2865drawCaretWithPathJKumZY($this$drawCaret, CaretType.Plain, density, configuration, containerColor6, caretSize5, anchorLayoutCoordinates);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                drawCaretModifier = $this$PlainTooltip_u2d7QI4Sbk.drawCaret(companion, (Function2) value$iv).then(modifier2);
            } else {
                $dirty2 = $dirty;
                containerColor3 = containerColor2;
                containerColor4 = caretSize3;
                drawCaretModifier = modifier2;
            }
            $composer3.endReplaceGroup();
            Shape shape5 = shape3;
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(drawCaretModifier, shape5, containerColor3, 0L, tonalElevation3, shadowElevation2, null, ComposableLambdaKt.rememberComposableLambda(1430116975, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
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
                    ComposerKt.sourceInformation($composer4, "C97@3886L590:Tooltip.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1430116975, $changed2, -1, "androidx.compose.material3.PlainTooltip.<anonymous> (Tooltip.android.kt:97)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(SizeKt.m730sizeInqDBjuR0$default(Modifier.INSTANCE, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getPlainTooltipMaxWidth(), 0.0f, 8, null), TooltipKt.getPlainTooltipContentPadding());
                        long j = contentColor2;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
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
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i9 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1903647947, "C106@4266L5,108@4285L181:Tooltip.android.kt#uh7d8r");
                        TextStyle textStyle = TypographyKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextFont(), $composer4, 6);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, $composer4, ProvidedValue.$stable);
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
            }, $composer3, 54), $composer2, (($dirty2 >> 6) & 112) | 12582912 | (($dirty2 >> 9) & 896) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty3 = $dirty2;
            modifier3 = modifier2;
            caretSize4 = containerColor4;
            contentColor3 = contentColor2;
            shape4 = shape5;
            containerColor5 = containerColor3;
            tonalElevation4 = tonalElevation3;
            shadowElevation3 = shadowElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
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
                    Tooltip_androidKt.m2862PlainTooltip7QI4Sbk($this$PlainTooltip_u2d7QI4Sbk, modifier3, caretSize4, shape4, contentColor3, containerColor5, tonalElevation4, shadowElevation3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: RichTooltip-yDvdmqw, reason: not valid java name */
    public static final void m2863RichTooltipyDvdmqw(final TooltipScope $this$RichTooltip_u2dyDvdmqw, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long caretSize, Shape shape, RichTooltipColors colors, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2 title;
        final Function2 action;
        long caretSize2;
        Shape shape2;
        int i2;
        RichTooltipColors colors2;
        float tonalElevation2;
        int $dirty;
        float shadowElevation2;
        RichTooltipColors colors3;
        long caretSize3;
        Modifier drawCaretModifier;
        Composer $composer2;
        final Function2 action2;
        final float tonalElevation3;
        final RichTooltipColors colors4;
        final Modifier modifier3;
        final Function2 title2;
        final Shape shape3;
        final float shadowElevation3;
        final long caretSize4;
        final long elevatedColor;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(1867454921);
        ComposerKt.sourceInformation($composer3, "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer3.changed($this$RichTooltip_u2dyDvdmqw) : $composer3.changedInstance($this$RichTooltip_u2dyDvdmqw) ? 4 : 2;
        }
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 384;
            title = function2;
        } else if (($changed & 384) == 0) {
            title = function2;
            $dirty2 |= $composer3.changedInstance(title) ? 256 : 128;
        } else {
            title = function2;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 3072;
            action = function22;
        } else if (($changed & 3072) == 0) {
            action = function22;
            $dirty2 |= $composer3.changedInstance(action) ? 2048 : 1024;
        } else {
            action = function22;
        }
        if (($changed & 24576) == 0) {
            if ((i & 8) == 0) {
                caretSize2 = caretSize;
                int i6 = $composer3.changed(caretSize2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                caretSize2 = caretSize;
            }
            $dirty2 |= i6;
        } else {
            caretSize2 = caretSize;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i7 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer3.changed(colors)) ? 1048576 : 524288;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(tonalElevation) ? 8388608 : 4194304;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 100663296;
            i2 = i9;
        } else if (($changed & 100663296) == 0) {
            i2 = i9;
            $dirty2 |= $composer3.changed(shadowElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i9;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if ((306783379 & $dirty2) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            colors4 = colors;
            $composer2 = $composer3;
            modifier3 = modifier2;
            title2 = title;
            action2 = action;
            shape3 = shape2;
            caretSize4 = caretSize2;
            tonalElevation3 = tonalElevation;
            shadowElevation3 = shadowElevation;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    title = null;
                }
                if (i5 != 0) {
                    action = null;
                }
                if ((i & 8) != 0) {
                    caretSize2 = DpSize.INSTANCE.m6800getUnspecifiedMYxV2XQ();
                    $dirty3 &= -57345;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -458753;
                    shape2 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape($composer3, 6);
                }
                if ((i & 32) != 0) {
                    colors2 = TooltipDefaults.INSTANCE.richTooltipColors($composer3, 6);
                    $dirty3 &= -3670017;
                } else {
                    colors2 = colors;
                }
                float tonalElevation4 = i8 != 0 ? ElevationTokens.INSTANCE.m3190getLevel0D9Ej5fM() : tonalElevation;
                if (i2 != 0) {
                    int i10 = $dirty3;
                    tonalElevation2 = tonalElevation4;
                    $dirty = i10;
                    shadowElevation2 = RichTooltipTokens.INSTANCE.m3488getContainerElevationD9Ej5fM();
                } else {
                    int i11 = $dirty3;
                    tonalElevation2 = tonalElevation4;
                    $dirty = i11;
                    shadowElevation2 = shadowElevation;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 32) != 0) {
                    int i12 = $dirty3 & (-3670017);
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    $dirty = i12;
                    colors2 = colors;
                } else {
                    colors2 = colors;
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty3;
                    tonalElevation2 = tonalElevation;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867454921, $dirty, -1, "androidx.compose.material3.RichTooltip (Tooltip.android.kt:147)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteTonalElevation = SurfaceKt.getLocalAbsoluteTonalElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localAbsoluteTonalElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((Dp) objConsume).m6707unboximpl();
            long elevatedColor2 = ColorSchemeKt.m1946applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme($composer3, 6), colors2.getContainerColor(), Dp.m6693constructorimpl(arg0$iv + tonalElevation2), $composer3, 0);
            Shape shape4 = shape2;
            $composer3.startReplaceGroup(1472746423);
            ComposerKt.sourceInformation($composer3, "153@6122L7,154@6181L7,155@6220L341");
            long $this$isSpecified$iv = caretSize2;
            if ($this$isSpecified$iv != InlineClassHelperKt.UnspecifiedPackedFloats) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Density density = (Density) objConsume2;
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer3.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Configuration configuration = (Configuration) objConsume3;
                Modifier.Companion companion = Modifier.INSTANCE;
                colors3 = colors2;
                ComposerKt.sourceInformationMarkerStart($composer3, 1472751513, "CC(remember):Tooltip.android.kt#9igjgp");
                boolean invalid$iv = $composer3.changed(density) | $composer3.changedInstance(configuration) | $composer3.changed(elevatedColor2) | ((((57344 & $dirty) ^ 24576) > 16384 && $composer3.changed(caretSize2)) || ($dirty & 24576) == 16384);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                    elevatedColor = elevatedColor2;
                } else {
                    elevatedColor = elevatedColor2;
                    if (it$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv = it$iv;
                        caretSize3 = caretSize2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    drawCaretModifier = $this$RichTooltip_u2dyDvdmqw.drawCaret(companion, (Function2) value$iv).then(modifier2);
                }
                final long caretSize5 = caretSize2;
                caretSize3 = caretSize5;
                value$iv = (Function2) new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$drawCaretModifier$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final DrawResult invoke(CacheDrawScope $this$drawCaret, LayoutCoordinates anchorLayoutCoordinates) {
                        return Tooltip_androidKt.m2865drawCaretWithPathJKumZY($this$drawCaret, CaretType.Rich, density, configuration, elevatedColor, caretSize5, anchorLayoutCoordinates);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                drawCaretModifier = $this$RichTooltip_u2dyDvdmqw.drawCaret(companion, (Function2) value$iv).then(modifier2);
            } else {
                colors3 = colors2;
                caretSize3 = caretSize2;
                drawCaretModifier = modifier2;
            }
            $composer3.endReplaceGroup();
            final RichTooltipColors colors5 = colors3;
            $composer2 = $composer3;
            SurfaceKt.m2561SurfaceT9BRK9s(SizeKt.m730sizeInqDBjuR0$default(drawCaretModifier, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape4, colors3.getContainerColor(), 0L, tonalElevation2, shadowElevation2, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x0187  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0191  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x02fa  */
                /* JADX WARN: Removed duplicated region for block: B:48:0x02fc  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x02ff  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x0301  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x035c  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0368  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x036e  */
                /* JADX WARN: Removed duplicated region for block: B:69:0x0450  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0456  */
                /* JADX WARN: Removed duplicated region for block: B:88:0x05d8  */
                /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r71, int r72) {
                    /*
                        Method dump skipped, instructions count: 1500
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }, $composer3, 54), $composer2, (($dirty >> 12) & 112) | 12582912 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            action2 = action;
            tonalElevation3 = tonalElevation2;
            colors4 = colors5;
            modifier3 = modifier2;
            title2 = title;
            shape3 = shape4;
            shadowElevation3 = shadowElevation2;
            caretSize4 = caretSize3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$2
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
                    Tooltip_androidKt.m2863RichTooltipyDvdmqw($this$RichTooltip_u2dyDvdmqw, modifier3, title2, action2, caretSize4, shape3, colors4, tonalElevation3, shadowElevation3, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-JKu-mZY, reason: not valid java name */
    public static final DrawResult m2865drawCaretWithPathJKumZY(CacheDrawScope $this$drawCaretWithPath_u2dJKu_u2dmZY, CaretType caretType, Density density, Configuration configuration, final long containerColor, long caretSize, final LayoutCoordinates anchorLayoutCoordinates) {
        float f;
        float anchorMidFromRightScreenEdge;
        long position;
        final Path path = AndroidPath_androidKt.Path();
        if (anchorLayoutCoordinates != null) {
            int caretHeightPx = density.mo361roundToPx0680j_4(DpSize.m6789getHeightD9Ej5fM(caretSize));
            int caretWidthPx = density.mo361roundToPx0680j_4(DpSize.m6791getWidthD9Ej5fM(caretSize));
            int $this$dp$iv = configuration.screenWidthDp;
            int screenWidthPx = density.mo361roundToPx0680j_4(Dp.m6693constructorimpl($this$dp$iv));
            int tooltipAnchorSpacing = density.mo361roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect anchorBounds = LayoutCoordinatesKt.boundsInWindow(anchorLayoutCoordinates);
            float anchorLeft = anchorBounds.getLeft();
            float anchorRight = anchorBounds.getRight();
            float anchorTop = anchorBounds.getTop();
            float anchorMid = (anchorRight + anchorLeft) / 2.0f;
            float anchorWidth = anchorRight - anchorLeft;
            float tooltipWidth = Size.m4014getWidthimpl($this$drawCaretWithPath_u2dJKu_u2dmZY.m3835getSizeNHjbRc());
            float tooltipHeight = Size.m4011getHeightimpl($this$drawCaretWithPath_u2dJKu_u2dmZY.m3835getSizeNHjbRc());
            boolean isCaretTop = (anchorTop - tooltipHeight) - ((float) tooltipAnchorSpacing) < 0.0f;
            if (isCaretTop) {
                f = 0.0f;
            } else {
                f = tooltipHeight;
            }
            float caretY = f;
            if (caretType != CaretType.Plain) {
                anchorMidFromRightScreenEdge = caretY;
                long preferredPosition = OffsetKt.Offset(anchorMid - anchorLeft, anchorMidFromRightScreenEdge);
                if (anchorLeft + tooltipWidth > screenWidthPx) {
                    preferredPosition = OffsetKt.Offset(anchorMid - (anchorRight - tooltipWidth), anchorMidFromRightScreenEdge);
                    if (anchorRight - tooltipWidth < 0.0f) {
                        if ((anchorLeft - (tooltipWidth / 2.0f)) + (anchorWidth / 2.0f) <= 0.0f) {
                            preferredPosition = OffsetKt.Offset(anchorMid, anchorMidFromRightScreenEdge);
                        } else if (((tooltipWidth / 2.0f) + anchorRight) - (anchorWidth / 2.0f) >= screenWidthPx) {
                            float caretX = tooltipWidth - (screenWidthPx - anchorMid);
                            preferredPosition = OffsetKt.Offset(caretX, anchorMidFromRightScreenEdge);
                        } else {
                            preferredPosition = OffsetKt.Offset(tooltipWidth / 2.0f, anchorMidFromRightScreenEdge);
                        }
                    }
                }
                position = preferredPosition;
            } else if ((tooltipWidth / 2.0f) + anchorMid > screenWidthPx) {
                float caretX2 = tooltipWidth - (screenWidthPx - anchorMid);
                anchorMidFromRightScreenEdge = caretY;
                position = OffsetKt.Offset(caretX2, anchorMidFromRightScreenEdge);
            } else {
                anchorMidFromRightScreenEdge = caretY;
                float tooltipLeft = anchorLeft - ((Size.m4014getWidthimpl($this$drawCaretWithPath_u2dJKu_u2dmZY.m3835getSizeNHjbRc()) / 2.0f) - (anchorWidth / 2.0f));
                float caretX3 = anchorMid - Math.max(tooltipLeft, 0.0f);
                position = OffsetKt.Offset(caretX3, anchorMidFromRightScreenEdge);
            }
            if (isCaretTop) {
                path.moveTo(Offset.m3945getXimpl(position), Offset.m3946getYimpl(position));
                path.lineTo(Offset.m3945getXimpl(position) + (caretWidthPx / 2), Offset.m3946getYimpl(position));
                path.lineTo(Offset.m3945getXimpl(position), Offset.m3946getYimpl(position) - caretHeightPx);
                path.lineTo(Offset.m3945getXimpl(position) - (caretWidthPx / 2), Offset.m3946getYimpl(position));
                path.close();
            } else {
                path.moveTo(Offset.m3945getXimpl(position), Offset.m3946getYimpl(position));
                path.lineTo(Offset.m3945getXimpl(position) + (caretWidthPx / 2), Offset.m3946getYimpl(position));
                path.lineTo(Offset.m3945getXimpl(position), Offset.m3946getYimpl(position) + caretHeightPx);
                path.lineTo(Offset.m3945getXimpl(position) - (caretWidthPx / 2), Offset.m3946getYimpl(position));
                path.close();
            }
        }
        return $this$drawCaretWithPath_u2dJKu_u2dmZY.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$drawCaretWithPath$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$onDrawWithContent) {
                if (anchorLayoutCoordinates != null) {
                    $this$onDrawWithContent.drawContent();
                    DrawScope.CC.m4743drawPathLG529CI$default($this$onDrawWithContent, path, containerColor, 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
